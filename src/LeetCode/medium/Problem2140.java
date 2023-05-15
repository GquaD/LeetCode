package LeetCode.medium;

public class Problem2140 {
    //https://leetcode.com/problems/solving-questions-with-brainpower/
    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println(mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
    }

    //nnnn
    //Runtime
    //10 ms
    //Beats
    //44.88%
    //Memory
    //100.8 MB
    //Beats
    //43.45%
    static long mostPoints(int[][] q) {
        long[] dp = new long[q.length * 4 + 1];
        for (int i = q.length - 1; i >= 0; i--)
            dp[i] = Math.max(q[i][0] + dp[q[i][1] + i + 1], dp[i + 1]);
        return dp[0];
    }
}
