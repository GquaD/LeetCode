package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1347 {
    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
    }
    //10 mins
    //Runtime: 147 ms, faster than 6.34% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
    //Memory Usage: 72.9 MB, less than 5.19% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
    static int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                count++;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return count;
    }
}
