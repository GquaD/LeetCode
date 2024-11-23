package LeetCode.medium;

public class Problem308 {
    //https://leetcode.com/problems/range-sum-query-2d-mutable
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/range-sum-query-2d-mutable/solutions/6075078/java-prefix-sum-solution/
    //10-15min
    //Runtime
    //32
    //ms
    //Beats
    //13.85%
    //Analyze Complexity
    //Memory
    //66.51
    //MB
    //Beats
    //5.37%
    class NumMatrix {
        int[][] mat;

        public NumMatrix(int[][] matrix) {
            mat = matrix;
            int sum = 0;
            for (int c = 0; c < mat[0].length; c++) {
                for (int r = 0; r < mat.length; r++) {
                    sum += mat[r][c];
                    mat[r][c] = sum;
                }
                sum = 0;
            }
        }

        public void update(int row, int col, int val) {
            int prev = row == 0 ? mat[row][col] : mat[row][col] - mat[row - 1][col];
            for (int r = row; r < mat.length; r++) {
                mat[r][col] = mat[r][col] - prev + val;
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            if (row1 == 0) {
                for (int c = col1; c <= col2; c++) {
                    sum += mat[row2][c];
                }
            } else {
                for (int c = col1; c <= col2; c++) {
                    sum += mat[row2][c] - mat[row1 - 1][c];
                }
            }

            return sum;
        }
    }

}


