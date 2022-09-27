package LeetCode.medium;

import java.util.*;

public class Problem990 {
    //https://leetcode.com/problems/satisfiability-of-equality-equations/
    public static void main(String[] args) {
        System.out.println(equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}));
        System.out.println(equationsPossible(new String[]{"a!=a"}));
        System.out.println(equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println(equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }

    // 55 mins
    //Runtime: 32 ms, faster than 6.03% of Java online submissions for Satisfiability of Equality Equations.
    //Memory Usage: 46.7 MB, less than 5.80% of Java online submissions for Satisfiability of Equality Equations.
    static boolean equationsPossible(String[] eq) {
        List<Set<Character>> listOfEqual = new ArrayList<>();
        List<String> negExprns = new ArrayList<>();
        for (int i = 0; i < eq.length; i++) {
            String expr = eq[i];
            char first = expr.charAt(0), second = expr.charAt(3);
            String operation = expr.charAt(1) + "" + expr.charAt(2);
            if (operation.equals("==")) {
                boolean added = false;
                for (Set<Character> set : listOfEqual) {
                    if (set.contains(first) || set.contains(second)) {
                        set.add(first);
                        set.add(second);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    Set<Character> set = new HashSet<>();
                    set.add(first);
                    set.add(second);
                    listOfEqual.add(set);
                }
            } else {
                negExprns.add(expr);
            }
        }
        for (int i = 0; i < eq.length; i++) {
            String expr = eq[i];
            char first = expr.charAt(0), second = expr.charAt(3);
            String operation = expr.charAt(1) + "" + expr.charAt(2);
            if (operation.equals("==")) {
                boolean added = false;
                for (Set<Character> set : listOfEqual) {
                    if (set.contains(first) || set.contains(second)) {
                        set.add(first);
                        set.add(second);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    Set<Character> set = new HashSet<>();
                    set.add(first);
                    set.add(second);
                    listOfEqual.add(set);
                }
            }
        }
        for (String expr : negExprns) {
            char first = expr.charAt(0), second = expr.charAt(3);
            if (first == second) return false;
            for (Set<Character> set : listOfEqual) {
                for (char c : set) {
                    if (set.contains(first) && set.contains(second)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean equationsPossible1(String[] eq) {
        //char -> list of equal values
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Set<Character>> mapNot = new HashMap<>();
        for (int i = 0; i < eq.length; i++) {
            String expr = eq[i];
            char first = expr.charAt(0), second = expr.charAt(3);
            if (!map.containsKey(first)) {
                Set<Character> set = new HashSet<>();
                set.add(first);
                map.put(first, set);
            }
            if (!mapNot.containsKey(first)) {
                Set<Character> set = new HashSet<>();
                mapNot.put(first, set);
            }
            if (!map.containsKey(second)) {
                Set<Character> set = new HashSet<>();
                set.add(second);
                map.put(second, set);
            }
            if (!mapNot.containsKey(second)) {
                Set<Character> set = new HashSet<>();
                mapNot.put(second, set);
            }
            String operation = expr.charAt(1) + "" + expr.charAt(2);
            if (operation.equals("==")) {
                map.get(first).add(second);
                map.get(second).add(first);
            } else {
                mapNot.get(first).add(second);
                mapNot.get(second).add(first);
            }
        }

        for (char key : map.keySet()) {
            Set<Character> set = map.get(key);
            for (char key2 : set) {
                if (mapNot.containsKey(key) && mapNot.get(key).contains(key2)) {
                    return false;
                }
            }
        }
        return true;

    }
}
