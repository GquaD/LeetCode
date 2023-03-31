package LeetCode.hard;

public class Problem1444 {
    //https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/description/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //7 ms
    //Beats
    //98.18%
    //Memory
    //40.7 MB
    //Beats
    //28.15%
    static int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        Integer[][][] dp = new Integer[k][rows][cols];
        int[][] prefixSum = new int[rows + 1][cols + 1];
        for (int r = rows - 1; r >= 0; r--) for (int c = cols - 1; c >= 0; c--) prefixSum[r][c] = prefixSum[r][c + 1] + prefixSum[r + 1][c] - prefixSum[r + 1][c + 1] + (pizza[r].charAt(c) == 'A' ? 1 : 0);
        return goDFS(rows, cols, k - 1, 0, 0, dp, prefixSum);
    }

    private static int goDFS(int rows, int cols, int k, int r, int c, Integer[][][] dp, int[][] prefixSum) {
        if (prefixSum[r][c] == 0) return 0;
        if (k == 0) return 1;
        if (dp[k][r][c] != null) return dp[k][r][c];
        int res = 0;
        for (int subrow = r + 1; subrow < rows; subrow++) if (prefixSum[r][c] - prefixSum[subrow][c] > 0) res = (res + goDFS(rows, cols, k - 1, subrow, c, dp, prefixSum)) % 1_000_000_007;
        for (int subcol = c + 1; subcol < cols; subcol++) if (prefixSum[r][c] - prefixSum[r][subcol] > 0) res = (res + goDFS(rows, cols, k - 1, r, subcol, dp, prefixSum)) % 1_000_000_007;
        return dp[k][r][c] = res;
    }

}
