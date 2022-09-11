package LeetCode.medium;

public class Problem1277 {
    //https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{
                {0,1,1},
                {1,1,1},
                {0,1,1}
        }));
        System.out.println(countSquares(new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        }));
    }

    //Runtime: 615 ms, faster than 5.05% of Java online submissions for Count Square Submatrices with All Ones.
    //Memory Usage: 69.4 MB, less than 57.63% of Java online submissions for Count Square Submatrices with All Ones.
    static int countSquares(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
        }
        int size = 2;
        while (m >= size && n >= size) {
            for (int row = 0; row <= m - size; row++) {
                for (int col = 0; col <= n - size; col++) {
                    if (isSquareValid(row, col, size, mat)) count++;
                }
            }
            size++;
        }
        return count;
    }

    private static boolean isSquareValid(int row, int col, int size, int[][] m) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (m[i][j] == 0) return false;
            }
        }
        return true;
    }
}
