package LeetCode.hard;

public class Problem1312 {
    //https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //43 ms
    //Beats
    //32.2%
    //Memory
    //43.6 MB
    //Beats
    //74.22%
    static int minInsertions(String s) {
        String sRev = new StringBuilder(s).reverse().toString();
        return s.length() - longestCommonSub(s, sRev, s.length(), s.length());
    }

    private static int longestCommonSub(String s1, String sRev, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == sRev.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    static int minInsertions1(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        int count = 0;
        for (int n : alph) if (n % 2 == 1) count++;
        return count - 1;
    }
}
