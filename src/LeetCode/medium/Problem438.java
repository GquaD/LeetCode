package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem438 {
    //https://leetcode.com/problems/find-all-anagrams-in-a-string
    public static void main(String[] args) {
        LeetCodeUtils.printList(findAnagrams("baa", "aa"));
        LeetCodeUtils.printList(findAnagrams("cbaebabacd", "abc"));
        LeetCodeUtils.printList(findAnagrams("abab", "ab"));
    }

    //Runtime: 1308 ms, faster than 6.20% of Java online submissions for Find All Anagrams in a String.
    //Memory Usage: 42.9 MB, less than 99.09% of Java online submissions for Find All Anagrams in a String.
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isAnagram(String substring, String p) {
        int[] alphabet = new int[26];
        for (int i = 0; i < p.length(); i++) {
            alphabet[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < substring.length(); i++) {
            alphabet[substring.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
