package LeetCode.medium;

public class Problem562 {
    //https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/solutions/5062444/java-o-n-solution/
    //15-20min
    //Runtime
    //8
    //ms
    //Beats
    //91.12%
    //of users with Java
    //Memory
    //45.88
    //MB
    //Beats
    //40.83%
    //of users with Java
    static int longestLine(int[][] mat) {
        int max = 0, rows = mat.length, cols = mat[0].length;
        //horizontal
        for (int r = 0; r < rows; r++) {
            int cur = 0;
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
            max = Math.max(max, cur);
        }
        //vertical
        for (int c = 0; c < cols; c++) {
            int cur = 0;
            for (int r = 0; r < rows; r++) {
                if (mat[r][c] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
            max = Math.max(max, cur);
        }

        //diagonal left to right
        for (int r = 0; r < rows; r++) {
            int cur = 0;
            int row = r, col = 0;
            while (cellExists(row, col, rows, cols)) {
                if (mat[row][col] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
                row--;
                col++;
            }
            max = Math.max(max, cur);
        }

        for (int c = 1; c < cols; c++) {
            int cur = 0;
            int row = rows - 1, col = c;
            while (cellExists(row, col, rows, cols)) {
                if (mat[row][col] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
                row--;
                col++;
            }
            max = Math.max(max, cur);
        }

        //diagonal right to left
        for (int r = 0; r < rows; r++) {
            int cur = 0;
            int row = r, col = cols - 1;
            while (cellExists(row, col, rows, cols)) {
                if (mat[row][col] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
                row--;
                col--;
            }
            max = Math.max(max, cur);
        }

        for (int c = cols - 2; c >= 0; c--) {
            int cur = 0;
            int row = rows - 1, col = c;
            while (cellExists(row, col, rows, cols)) {
                if (mat[row][col] == 1) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
                row--;
                col--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    private static boolean cellExists(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
