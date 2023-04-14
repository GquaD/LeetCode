package LeetCode.medium;

import java.util.Stack;

public class Problem516 {
    //https://leetcode.com/problems/longest-palindromic-subsequence/description/
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    //nnnn
    //Runtime
    //106 ms
    //Beats
    //15.73%
    //Memory
    //52.3 MB
    //Beats
    //21.37%
    static int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        String t = new StringBuilder(s).reverse().toString();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    static int longestPalindromeSubseq1(String s) {
        int count = 0, count2 = 0, half = s.length() / 2;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < half; i++) stack.push(s.charAt(i));
        for (int i = s.length() % 2 == 1 ? half + 1 : half; i < s.length(); i++) {
            if (stack.peek() == s.charAt(i)) {
                count++;
                stack.pop();
            }
        }
        stack = new Stack<>();
        for (int i = s.length() - 1; i >= (s.length() % 2 == 1 ? half + 1 : half); i--) stack.push(s.charAt(i));
        for (int i = 0; i < half; i++) {
            if (stack.peek() == s.charAt(i)) {
                count2++;
                stack.pop();
            }
        }
        return Math.max(count, count2);
    }
}
