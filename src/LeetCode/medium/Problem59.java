package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem59 {
    //https://leetcode.com/problems/spiral-matrix-ii/description/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(generateMatrix(3));
        LeetCodeUtils.print2DArray(generateMatrix(4));
    }

    //https://leetcode.com/problems/spiral-matrix-ii/solutions/2712914/java-solution/
    //1 hour
    //Runtime
    //1 ms
    //Beats
    //15.67%
    //Memory
    //42.3 MB
    //Beats
    //27.93%
    static int[][] directions = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    static int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int row = 0, col = 0;
        int centerRow = n / 2, centerCol = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int counter = 1;
        m[row][col] = counter++;
        int dirCount = 0;
        int[] direction = directions[dirCount];
        while (!(row == centerRow && col == centerCol)) {
            if (cellExists(row + direction[0], col + direction[1], m)) {
                row += direction[0];
                col += direction[1];
                m[row][col] = counter++;
            } else {
                dirCount++;
                direction = directions[dirCount % 4];
            }
        }
        return m;
    }

    static int[][] generateMatrix1(int n) {
        int[][] m = new int[n][n];
        //boolean[][] visited = new boolean[n][n];
        int row = 0, col = 0;
        int centerRow = n / 2, centerCol = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int counter = 1;
        m[row][col] = counter++;
        //visited[row][col] = true;
        while (!(row == centerRow && col == centerCol)) {
            if (cellExists(row, col + 1, m)) {
                col++;
                m[row][col] = counter++;
            } else if (cellExists(row + 1, col, m)) {
                row++;
                m[row][col] = counter++;
            } else if (cellExists(row, col - 1, m)) {
                col--;
                m[row][col] = counter++;
            } else if (cellExists(row - 1, col, m)) {
                row--;
                m[row][col] = counter++;
            }
        }
        return m;
    }

    private static boolean cellExists(int row, int col, int[][] m) {
        return row >= 0 && row < m.length && col >= 0 && col < m[0].length && m[row][col] == 0;
    }
}
