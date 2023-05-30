package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem409 {
    //https://leetcode.com/problems/longest-palindrome/
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("ababababa"));
    }

    //5-10min
    //Runtime
    //3 ms
    //Beats
    //70.71%
    //Memory
    //40.9 MB
    //Beats
    //64.15%
    public static int longestPalindrome(String s) {
        int alphLow[] = new int[26], alphUp[] = new int[26], count = 0, hasOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) alphLow[c - 'a']++;
            else alphUp[c - 'A']++;
        }
        for (int n : alphLow) {
            count += n % 2 == 0 ? n : n - 1;
            if (n % 2 == 1) hasOdd++;
        }
        for (int n : alphUp) {
            count += n % 2 == 0 ? n : n - 1;
            if (n % 2 == 1) hasOdd++;
        }
        return hasOdd > 0 ? count + 1 : count;
    }

    //Runtime: 7 ms, faster than 44.71% of Java online submissions for Longest Palindrome.
    //Memory Usage: 40.4 MB, less than 95.18% of Java online submissions for Longest Palindrome.
    public static int longestPalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (map.keySet().size() == 1) {
            return s.length();
        }

        int count = 0;
        boolean hasOdd = false;
        for (Character c : map.keySet()) {
            int temp = map.get(c);
            if (temp >= 2) {
                count += ((temp / 2) * 2);
            }
            if (temp % 2 == 1) {
                hasOdd = true;
            }
        }
        if (hasOdd) {
            count++;
        }
        return count;
    }
}
