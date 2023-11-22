package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem2452 {
    //https://leetcode.com/problems/words-within-two-edits-of-dictionary/
    public static void main(String[] args) {
        LeetCodeUtils.printList(twoEditWords(new String[]{"word","note","ants","wood"}, new String[]{"wood","joke","moat"}));
        LeetCodeUtils.printList(twoEditWords(new String[]{"yes"}, new String[]{"not"}));
        LeetCodeUtils.printList(twoEditWords(new String[]{"ai"}, new String[]{"bn"}));
    }

    //https://leetcode.com/problems/words-within-two-edits-of-dictionary/solutions/4317321/java-straghtforward-solution/
    //15-20 min
    //Runtime
    //13 ms
    //Beats
    //51.50%
    //Memory
    //41.9 MB
    //Beats
    //61.8%
    static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < dictionary.length; j++) {
                if (withinTwoEdits(queries[i], dictionary[j])) {
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }

    private static boolean withinTwoEdits(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != t.charAt(i)) diff++;
        return diff <= 2;
    }

    static List<String> twoEditWords1(String[] queries, String[] dictionary) {
        int[][] q = new int[queries.length][26], d = new int[queries.length][26];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            for (int j = 0; j < s.length(); j++) q[i][s.charAt(j) - 'a']++;
        }

        for (int i = 0; i < dictionary.length; i++) {
            String s = dictionary[i];
            for (int j = 0; j < s.length(); j++) d[i][s.charAt(j) - 'a']++;
        }


        List<String> list = new ArrayList<>();
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (withinTwoEdits1(q[i], d[j])) {
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }

    private static boolean withinTwoEdits1(int[] q, int[] d) {
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(q[i] - d[i]);
        }
        return diff % 2 == 0 && diff <= 4;
    }
}
