package LeetCode.easy;

import java.util.Arrays;

public class Problem557 {
    //https://leetcode.com/problems/reverse-words-in-a-string-iii/
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("s'teL ekat edoCteeL tsetnoc"));
        System.out.println(reverseWords("God Ding"));
    }

    //Runtime: 10 ms, faster than 61.13% of Java online submissions for Reverse Words in a String III.
    //Memory Usage: 52 MB, less than 41.70% of Java online submissions for Reverse Words in a String III.
    static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(reverse(words[i], sb1)).append(" ");
            sb1.setLength(0);
        }
        return sb.toString().trim();
    }
    private static String reverse(String word, StringBuilder sb) {
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(word.length() - 1 - i));
        }
        return sb.toString();
    }
}
