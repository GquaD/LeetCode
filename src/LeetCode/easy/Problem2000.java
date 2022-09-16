package LeetCode.easy;

import LeetCode.Recursion.ReverseString;

public class Problem2000 {
    //https://leetcode.com/problems/reverse-prefix-of-word/
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }
    //Runtime: 3 ms, faster than 26.17% of Java online submissions for Reverse Prefix of Word.
    //Memory Usage: 42.1 MB, less than 60.79% of Java online submissions for Reverse Prefix of Word.
    public static String reversePrefix(String word, char ch) {
        if (!word.contains(ch + "")) {
            return word;
        }

        int index = word.indexOf(ch) + 1;
        String toRevert = word.substring(0, index);
        String reverted = revert(toRevert);
        return reverted + word.substring(index);
    }

    static String revert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
