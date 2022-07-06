package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem1941 {
    //https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
        System.out.println(areOccurrencesEqual("aaabb"));
    }
    //Runtime: 13 ms, faster than 23.45% of Java online submissions for Check if All Characters Have Equal Number of Occurrences.
    //Memory Usage: 42.5 MB, less than 54.55% of Java online submissions for Check if All Characters Have Equal Number of Occurrences.
    static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int times = map.get(s.charAt(0));
        for (Character c : map.keySet()) {
            if (times != map.get(c)) {
                return false;
            }
        }
        return true;
    }
}
