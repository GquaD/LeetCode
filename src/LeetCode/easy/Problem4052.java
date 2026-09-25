package LeetCode.easy;

public class Problem4052 {
    //10-15min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //47.33
    //MB
    //Beats
    //63.76%
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < rowShift.length; i++) {
            int k = rowShift[i];
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[i][(j + k) % n];
            }
        }

        for (int i = 0; i < colShift.length; i++) {
            int k = colShift[i];
            for (int j = 0; j < n; j++) {
                grid[j][i] = arr[(j + k) % n][i];
            }
        }

        return grid;
    }
}
