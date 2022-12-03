package LeetCode.medium;

public class Problem73 {
    //https://leetcode.com/problems/set-matrix-zeroes/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/set-matrix-zeroes/solutions/2871716/java-o-n-2-ms-solution/
    //10-20min
    //Runtime
    //2 ms
    //Beats
    //60.98%
    //Memory
    //54.5 MB
    //Beats
    //18.34%
    static void setZeroes(int[][] m) {
        int r = m.length, c = m[0].length;
        boolean[][] zeros = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 0) zeros[i][j] = true;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (zeros[i][j] == true) {
                    fillRowWithZeros(i, m);
                    fillColumnWithZeros(j, m);
                }
            }
        }
    }

    private static void fillRowWithZeros(int row, int[][] m) {
        for (int i = 0; i < m[row].length; i++) {
            m[row][i] = 0;
        }
    }

    private static void fillColumnWithZeros(int col, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            m[i][col] = 0;
        }
    }
}
