package LeetCode.medium;

public class Problem1901 {
    //https://leetcode.com/problems/find-a-peak-element-ii/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //11 ms
    //Beats
    //5.17%
    //Memory
    //82.2 MB
    //Beats
    //5.55%
    static int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int up = cellExists(i - 1, j, mat) ? mat[i - 1][j] : -1;
                int right = cellExists(i, j + 1, mat) ? mat[i][j + 1] : -1;
                int down = cellExists(i + 1, j, mat) ? mat[i + 1][j] : -1;
                int left = cellExists(i, j - 1, mat) ? mat[i][j - 1] : -1;
                int curr = mat[i][j];
                if (curr > up && curr > right && curr > down && curr > left) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }

    private static boolean cellExists(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
