package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1684 {
    //https://leetcode.com/problems/count-the-number-of-consistent-strings/

    public static void main(String[] args) {
        System.out.println(countConsistentStrings2("ab",
                new String[]{"ad","bd","aaab","baa","badab"}));
    }
    //Runtime: 57 ms, faster than 12.45% of Java online submissions for Count the Number of Consistent Strings.
    //Memory Usage: 67.9 MB, less than 19.76% of Java online submissions for Count the Number of Consistent Strings.
    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        outerloop:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!allowed.contains(c + "")) {
                    continue outerloop;
                }
            }
            count++;
        }
        return count;
    }

    //Runtime: 49 ms, faster than 17.25% of Java online submissions for Count the Number of Consistent Strings.
    //Memory Usage: 73.8 MB, less than 5.16% of Java online submissions for Count the Number of Consistent Strings.
    public static int countConsistentStrings2(String allowed, String[] words) {
        int count = 0;
        outerloop:
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!contains(allowed, c)) {
                    continue outerloop;
                }
            }
            count++;
        }
        return count;
    }

    private static boolean contains(String allowed, char c) {
        for (char aChar : allowed.toCharArray()) {
            if (aChar == c) {
                return true;
            }
        }
        return false;
    }

}
