package LeetCode;

public class Problem776 {
    //https://leetcode.com/problems/toeplitz-matrix/
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2},
                {2,2}
        }));
    }

    //Runtime: 1 ms, faster than 95.16% of Java online submissions for Toeplitz Matrix.
    //Memory Usage: 42.4 MB, less than 92.09% of Java online submissions for Toeplitz Matrix.
    static boolean isToeplitzMatrix(int[][] matrix) {
        int diagonals = matrix.length + matrix[0].length - 1;
        int rows = matrix.length;
        boolean isTrue = true;
        int col = 0, row = 0;
        for (int i = 0; i < diagonals; i++) {
            if (i >= rows) {
                col = i - rows;
                row = 0;
            } else {
                col = 0;
                row = matrix.length - 1 - i;
            }
            int prev = matrix[row++][col++];
            while (cellExists(row, col, matrix)) {
                if (prev != matrix[row][col]) {
                    isTrue = false;
                    break;
                }
                row++;
                col++;
            }

            if (!isTrue) {
                return isTrue;
            }
        }
        return true;
    }

    private static boolean cellExists(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
