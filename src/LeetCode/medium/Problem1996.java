package LeetCode.medium;

import java.util.*;

public class Problem1996 {
    //https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][]{{1,27},{47,48},{19,59},{56,90},{69,55},{64,61},{90,9},{34,48},{27,84},{59,5},{21,51},{26,91},{3,60},{47,77},{97,29},{89,52},{59,97},{52,29},{63,41},{14,6},{21,27},{58,68},{69,25},{57,24},{63,39},{93,33},{53,10},{9,26}}));
        System.out.println(numberOfWeakCharacters(new int[][]{
                {2,2},
                {3,3}
        }));
        System.out.println(numberOfWeakCharacters(new int[][]{
                {29, 26}, {92, 1}, {81, 64}, {41, 54}, {56, 74},
                {76, 39}, {16, 69}, {78, 84}, {65, 39}, {7, 2},
                {62, 96}, {16, 22}, {47, 34}, {16, 22}, {66, 26},
                {93, 49}, {55, 16}, {41, 21}, {11, 73}, {17, 1},
                {63, 81}, {90, 37}, {83, 50}, {7, 97}, {86, 14},
                {68, 67}, {65, 63}, {35, 32}, {100, 1}, {23, 4},
                {17, 6}, {74, 52}, {98, 90}, {4, 15}, {31, 36},
                {69, 53}, {17, 33}, {80, 56}, {8, 100}, {94, 85},
                {89, 76}, {14, 76}, {31, 85}, {89, 54}, {73, 69},
                {55, 7}, {73, 13}, {31, 100}, {29, 55}, {82, 6},
                {12, 66}, {17, 72}, {45, 50}, {99, 73}, {41, 10},
                {89, 16}, {69, 35}, {72, 34}, {85, 49}, {12, 5},
                {61, 42}, {32, 28}, {10, 55}, {61, 19}, {17, 4},
                {48, 59}, {15, 44}, {7, 48}, {1, 92}, {68, 12},
                {23, 6}, {5, 92}, {70, 49}, {59, 3}, {9, 62},
                {50, 6}, {75, 39}, {7, 79}, {35, 80}, {94, 41},
                {25, 43}, {44, 16}, {3, 68}, {87, 62}, {70, 62},
                {68, 49}, {8, 46}, {16, 7}, {16, 60}, {42, 48}}));
        //84
    }

    //Runtime: 222 ms, faster than 19.55% of Java online submissions for The Number of Weak Characters in the Game.
    //Memory Usage: 129 MB, less than 81.26% of Java online submissions for The Number of Weak Characters in the Game.
    public int numberOfWeakCharactersFinal(int[][] properties) {
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int noOfWeakCharacters = 0;
        int len = properties.length;

        int max = properties[len-1][1];

        for(int i = len-2; i>=0 ;i--) {

            if(properties[i][1] < max) {
                noOfWeakCharacters++;
            } else {
                max = properties[i][1];
            }
        }
        return noOfWeakCharacters;
    }

    static int numberOfWeakCharacters3(int[][] p) {
        int maxSum = 0, minDiff = 0, maxAtt = 0, maxDef = 0;
        int iMaxSum = 0, iMaxAtt = 0, iMaxDef = 0;
        for (int i = 0; i < p.length; i++) {
            int attack = p[i][0];
            int defense = p[i][1];
            //attack
            if (maxAtt < attack) {
                maxAtt = attack;
                iMaxAtt = i;
            }
            if (maxAtt == attack && p[iMaxAtt][1] < defense) {
                iMaxAtt = i;
            }
            //defense
            if (maxDef < defense) {
                maxDef = defense;
                iMaxDef = i;
            }
            if (maxDef == defense && p[iMaxDef][0] < attack) {
                iMaxDef = i;
            }
            //sum
            int currSum = attack + defense;
            if (maxSum < currSum) {
                maxSum = currSum;
                iMaxSum = i;
            }
            if (maxSum == currSum && minDiff > Math.abs(attack - defense)) {
                iMaxSum = i;
            }
        }
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i][0] < p[iMaxAtt][0] && p[i][1] < p[iMaxAtt][1]
                || p[i][0] < p[iMaxDef][0] && p[i][1] < p[iMaxDef][1]
                || p[i][0] < p[iMaxSum][0] && p[i][1] < p[iMaxSum][1]) {
                count++;
            }
        }
        return count;
    }
    static int numberOfWeakCharacters(int[][] p) {
        if (p.length < 10000) {
            return numberOfWeakCharacters5(p);
        } else {
            int numOfGroups = p.length / 100;
            if (numOfGroups * 100 < p.length) {
                numOfGroups++;
            }
            Map<Integer, List<Element>> map = new HashMap<>();

            for (int i = 0; i < p.length; i++) {
                int attack = p[i][0];
                int groupToGo = attack / 100;
                if (map.containsKey(groupToGo)) {
                    List<Element> list = map.get(groupToGo);
                    list.add(new Element(p[i][0], p[i][1], i));
                } else {
                    List<Element> list = new ArrayList<>();
                    list.add(new Element(p[i][0], p[i][1], i));
                    map.put(groupToGo, list);
                }
            }
            int count = 0;
            for (int i = 0; i < p.length; i++) { // O(N)
                int currentAttack = p[i][0];
                int currentDef = p[i][1];
                outerloop:
                for (Integer key : map.keySet()) {
                    List<Element> elements = map.get(key);
                    for (int j = 0; j < elements.size(); j++) {
                        Element element = elements.get(j);
                        if (currentDef < element.defense && currentAttack < element.attack) {
                            count++;
                            break outerloop;
                        }
                    }
                }
            }
            return count;
        }
    }

    static class Element{
        int attack;
        int defense;
        int index;

        public Element(int attack, int defense, int index) {
            this.attack = attack;
            this.defense = defense;
            this.index = index;
        }
    }
    //time limit exceeded for case with 100 000 pairs
    //use list instead of map?
    static int numberOfWeakCharacters5(int[][] p) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            int attack = p[i][0];
            if (max < attack) {
                max = attack;
            }
            if (map.containsKey(attack)) {
                map.get(attack).add(i);
            } else {
                List<Integer> indices = new LinkedList<>();
                indices.add(i);
                map.put(attack, indices);
            }
        }
        int count = 0;

        for (int i = 0; i < p.length; i++) { // O(N)
            int currentAttack = p[i][0];
            int currentDef = p[i][1];
            outerloop:
            for (Integer key : map.keySet()) {
                List<Integer> indices = map.get(key);
                for (int j = 0; j < indices.size(); j++) {
                    int idx = indices.get(j);
                    if (currentDef < p[idx][1] && currentAttack < p[idx][0]) {
                        count++;
                        break outerloop;
                    }
                }
            }
        }
        /*for (int i = 0; i < p.length; i++) {
            int attack = max;
            int currentAttack = p[i][0];
            int currentDef = p[i][1];
            outerloop:
            while (attack > currentAttack) {
                if (map.containsKey(attack)) {
                    List<Integer> indices = map.get(attack);
                    for (int j = 0; j < indices.size(); j++) {
                        if (currentDef < p[indices.get(j)][1]) {
                            count++;
                            break outerloop;
                        }
                    }
                }
                attack--;
            }
        }*/
        return count;
    }

    static class Group {
        int key;
        List<Integer> indices;

        public Group(int k) {
            key = k;
            indices = new ArrayList<>();
        }
    }

    //trying O(n^2) solution
    //time limit exceeded
    static int numberOfWeakCharacters2(int[][] p) {
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[i][0] < p[j][0] && p[i][1] < p[j][1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    //wanted O(n) solution, but didn't work
    static int numberOfWeakCharacters1(int[][] p) {
        int maxAttack = 0, maxDef = 0;
        int indexMaxAtt = 0, indexMaxDef = 0;
        for (int i = 0; i < p.length; i++) {
            if (maxAttack <= p[i][0] && (p[indexMaxAtt][0] + p[indexMaxAtt][1]) < (p[i][0] + p[i][1])) {
                maxAttack = p[i][0];
                indexMaxAtt = i;
            }
            if (maxDef < p[i][1] && (p[indexMaxDef][0] + p[indexMaxDef][1]) < (p[i][0] + p[i][1])) {
                maxDef = p[i][1];
                indexMaxDef = i;
            }
        }
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if ((p[i][0] < p[indexMaxAtt][0] && p[i][1] < p[indexMaxAtt][1])
                    || (p[i][0] < p[indexMaxDef][0] && p[i][1] < p[indexMaxDef][1])) {
                count++;
            }
        }
        return count;
    }
}
