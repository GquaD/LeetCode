package LeetCode;

public class Problem1332 {
    //https://leetcode.com/problems/remove-palindromic-subsequences/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/remove-palindromic-subsequences/discuss/2582564/Java-Solution-0-ms-or-100-faste
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Palindromic Subsequences.
    //Memory Usage: 41.7 MB, less than 63.45% of Java online submissions for Remove Palindromic Subsequences.
    static int removePalindromeSub(String s) {
        if (isPalindromic(s)) return 1;
        else return 2;
    }

    private static boolean isPalindromic(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
