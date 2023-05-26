package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1190 {
    //https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    //https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/solutions/3565872/java-solution-using-list/
    //20 min
    //Runtime
    //8 ms
    //Beats
    //11.45%
    //Memory
    //41.2 MB
    //Beats
    //60.31%
    static String reverseParentheses(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        list.add("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
                if (list.size() <= count) list.add("");
            } else if (c == ')') {
                String t = sb.append(list.get(count)).reverse().toString();
                list.set(count, "");
                sb.setLength(0);
                list.set(count - 1, list.get(count - 1) + t);
                count--;
            } else {
                list.set(count, list.get(count) + c);
            }
        }
        return list.get(0);
    }

    static String reverseParentheses1(String s) {
        List<List<String>> list = new ArrayList<>();
        int lvl = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (list.size() <= lvl) {
                    list.add(new ArrayList<>());
                }
                list.get(lvl).add(sb.toString());
                sb.setLength(0);
                lvl++;
            } else if (c == ')') {
                list.get(lvl).add(sb.toString());
                sb.setLength(0);
                lvl--;
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) list.get(lvl).add(sb.toString());
        sb.setLength(0);
        for (int i = list.size() - 1; i >= 0; i--) {
            StringBuilder sbTemp = new StringBuilder();
            List<String> strings = list.get(i);
            for (int j = 0; j < strings.size(); j++) {
                sb.append(sbTemp.append(strings.get(j)).reverse());
            }

        }
        return "";
    }
}
