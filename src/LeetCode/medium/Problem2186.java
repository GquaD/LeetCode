package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2186 {
    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
    public static void main(String[] args) {
        System.out.println(minSteps("leetcode", "coats"));
        System.out.println(minSteps("thing", "night"));
    }
    //todo improve
    //Runtime: 357 ms, faster than 5.07% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram II.
    //Memory Usage: 107 MB, less than 22.95% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram II.
    static int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int steps = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else steps++;
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                steps += Math.abs(map.get(c));
            }
        }
        return steps;
    }
}
