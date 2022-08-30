package LeetCode;

public class Problem1252 {
    //https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
    public static void main(String[] args) {

    }

    //less than 5 mins
    //Runtime: 1 ms, faster than 90.81% of Java online submissions for Cells with Odd Values in a Matrix.
    //Memory Usage: 40.4 MB, less than 93.52% of Java online submissions for Cells with Odd Values in a Matrix.
    static int oddCells(int m, int n, int[][] indices) {
        int[][] result = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            incrementCellsInRow(result, indices[i][0]);
            incrementCellsInColumn(result, indices[i][1]);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void incrementCellsInRow(int[][] result, int row) {
        for (int i = 0; i < result[0].length; i++) {
            result[row][i]++;
        }
    }

    private static void incrementCellsInColumn(int[][] result, int col) {
        for (int i = 0; i < result.length; i++) {
            result[i][col]++;
        }
    }
}
