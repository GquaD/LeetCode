package LeetCode.easy;

import LeetCode.LeetCodeUtils;

public class Problem2373 {
    //https://leetcode.com/problems/largest-local-values-in-a-matrix/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(largestLocal(new int[][]{
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        }));
    }

    //Runtime: 3 ms, faster than 86.50% of Java online submissions for Largest Local Values in a Matrix.
    //Memory Usage: 51.7 MB, less than 75.05% of Java online submissions for Largest Local Values in a Matrix.
    static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (max < grid[k][l]) {
                            max = grid[k][l];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
