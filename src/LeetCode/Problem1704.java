package LeetCode;

import java.util.Locale;

public class Problem1704 {
    //https://leetcode.com/problems/determine-if-string-halves-are-alike/
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas"));
    }
    //Runtime: 5 ms, faster than 66.85% of Java online submissions for Determine if String Halves Are Alike.
    //Memory Usage: 42.6 MB, less than 32.91% of Java online submissions for Determine if String Halves Are Alike.
    static final String vowels = "aeiou";
    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int half = s.length() / 2;
        String left = s.substring(0, half);
        String right = s.substring(half);
        return countVowels(left) == countVowels(right);
    }

    static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            for (int j = 0; j < vowels.length(); j++) {
                if (temp == vowels.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
