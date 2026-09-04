package LeetCode.medium;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Problem3 {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    //Runtime
    //27
    //ms
    //Beats
    //53.68%
    //Memory
    //47.24
    //MB
    //Beats
    //60.39%
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int len = 0, max = 0, repeatIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer lastIdx = map.get(c);
            if (lastIdx == null) {
                len++;
            } else {
                max = Math.max(len, max);
                repeatIdx = Math.max(repeatIdx, lastIdx);
                len = i - repeatIdx;
            }
            map.put(c, i);
        }
        return Math.max(len, max);
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/2625638/Java-Bad-Solution
    //10 mins
    //Runtime: 483 ms, faster than 5.62% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 117.8 MB, less than 7.11% of Java online submissions for Longest Substring Without Repeating Characters.
    static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new TreeSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = i;
            while (count < s.length() && set.add(s.charAt(count))) {
                count++;
            }
            if (maxLength < set.size()) {
                maxLength = set.size();
            }
            set.clear();
        }
        return maxLength;
    }
}
