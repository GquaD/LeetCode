package LeetCode.medium;

public class Problem807 {
    //https://leetcode.com/problems/max-increase-to-keep-city-skyline/
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        }));

        System.out.println(maxIncreaseKeepingSkyline(new int[][]{
                {8, 4, 8, 7},
                {7, 4, 7, 7},
                {9, 4, 8, 7},
                {3, 3, 3, 3}
        }));
    }

    //Runtime: 2 ms, faster than 29.30% of Java online submissions for Max Increase to Keep City Skyline.
    //Memory Usage: 44.2 MB, less than 47.49% of Java online submissions for Max Increase to Keep City Skyline.
    static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowsMax = new int[n];
        int[] columnsMax = new int[n];
        int sumInit = 0, sumEnd = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            rowsMax[i] = max;
            max = 0;
            for (int j = 0; j < n; j++) {
                if (max < grid[j][i]) {
                    max = grid[j][i];
                }
            }
            columnsMax[i] = max;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumInit += grid[i][j];
                grid[i][j] = Math.min(rowsMax[i], columnsMax[j]);
                sumEnd += grid[i][j];
            }

        }
        return sumEnd - sumInit;
    }
}
