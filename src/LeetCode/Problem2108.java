package LeetCode;

public class Problem2108 {
    //https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"}));
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }

    //Runtime: 4 ms, faster than 72.58% of Java online submissions for Find First Palindromic String in the Array.
    //Memory Usage: 51.6 MB, less than 33.59% of Java online submissions for Find First Palindromic String in the Array.
    static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (checkIfPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean checkIfPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
