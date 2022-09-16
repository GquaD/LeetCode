package LeetCode.easy;

public class Problem1967 {
    //https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
    public static void main(String[] args) {

    }
    //Runtime: 1 ms, faster than 85.34% of Java online submissions for Number of Strings That Appear as Substrings in Word.
    //Memory Usage: 43.1 MB, less than 13.16% of Java online submissions for Number of Strings That Appear as Substrings in Word.
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                count++;
            }
        }
        return count;
    }
}
