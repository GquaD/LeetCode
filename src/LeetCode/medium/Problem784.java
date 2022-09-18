package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem784 {
    //https://leetcode.com/problems/letter-case-permutation/
    public static void main(String[] args) {
        LeetCodeUtils.printList(letterCasePermutation("a1b2"));
        LeetCodeUtils.printList(letterCasePermutation("a1b2c3"));

    }

    //https://leetcode.com/problems/letter-case-permutation/discuss/2592335/Java-Solution
    //Runtime: 336 ms, faster than 5.01% of Java online submissions for Letter Case Permutation.
    //Memory Usage: 118.7 MB, less than 5.17% of Java online submissions for Letter Case Permutation.
    static Set<String> set;
    static String initial;
    static int len;

    static List<String> letterCasePermutation(String s) {
        initial = s;
        len = s.length();
        set = new HashSet<>();
        set.add(s);
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            generateVariants(sb, i);
        }

        return new ArrayList<>(set);
    }

    private static void generateVariants(StringBuilder sb, int i) {
        if (sb.length() == len) {
            set.add(sb.toString());
            return;
        }
        if (i >= len) return;
        char c = initial.charAt(i);
        sb.append(c);
        for (int j = i + 1; j <= initial.length(); j++) {
            generateVariants(sb, j);
        }
        sb.setLength(sb.toString().length() - 1);


        if (c >= 'a' && c <= 'z') {
            sb.append((char) (c - 32));
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c + 32));
        } else {
            sb.append(c);
        }

        for (int j = i + 1; j <= initial.length(); j++) {
            generateVariants(sb, j);
        }
        sb.setLength(sb.toString().length() - 1);
    }
    /*
    static List<String> letterCasePermutation(String s) {
        char[] lows = s.toCharArray();
        char[] caps = new char[s.length()];
        for (int i = 0; i < lows.length; i++) {
            char c = lows[i];
            if (c >= 'a' && c <= 'z') {
                caps[i] = (char) (c - 32);
            } else if (c >= 'A' && c <= 'Z') {
                caps[i] = (char) (c + 32);
            } else caps[i] = c;
        }
        return null;
    }
    */

}
