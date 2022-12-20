package LeetCode.medium;

public class Problem1706 {
    //https://leetcode.com/problems/where-will-the-ball-fall/
    public static void main(String[] args) {

    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        if (grid[0][0] == -1 || grid[0][n - 1] == 1) {
            res[0] = -1;
        }
        for (int col = 1; col < n - 1; col++) {
            for (int row = 0; row < grid.length; row++) {

            }
        }
        return null;
    }
}
