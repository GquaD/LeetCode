package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem885 {
    //https://leetcode.com/problems/spiral-matrix-iii/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(spiralMatrixIII(5, 6, 1, 4));
        System.out.println();
        LeetCodeUtils.print2DArray(spiralMatrixIII(1, 4, 0, 0));
    }

    //nnnn
    //Runtime
    //4 ms
    //Beats
    //73.1%
    //Memory
    //43.8 MB
    //Beats
    //34.37%

    static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[] dr = new int[]{0, 1, 0, -1}, dc = new int[]{1, 0, -1, 0};
        int t = 0, size = rows * cols;
        int[][] res = new int[size][2];

        res[t++] = new int[]{rStart, cStart};
        if (size == 1) return res;
        for (int i = 1; i < 2 * (rows + cols); i+=2) {
            for (int j = 0; j < 4; j++) {
                int dj = i + (j / 2);
                for (int k = 0; k < dj; k++) {
                    rStart += dr[j];
                    cStart += dc[j];
                    if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
                        res[t++] = new int[]{rStart, cStart};
                        if (t == size) return res;
                    }
                }
            }
        }
        return res;
    }

    static int[][] spiralMatrixIIIq(int rows, int cols, int rStart, int cStart) {
        boolean[][] visited = new boolean[rows][cols];
        int count = 0, size = rows * cols, step = 0, r = rStart, c = cStart;
        visited[r][c] = true;
        int[][] res = new int[size][2];
        int[] curr = new int[]{r, c};
        res[count++] = curr;
        boolean hasChanged = true;
        while (count < size) {
            step++;
            if (hasChanged) curr = new int[]{res[count - 1][0], res[count - 1][1] + 1};
            //right
            hasChanged = false;
            r = curr[0];
            c = curr[1];
            for (int i = c; i < c + step; i++) {
                if (cellExists(r, i, rows, cols)) {
                    if (!visited[r][i]) {
                        visited[r][i] = true;
                        res[count++] = new int[]{r, i};
                        hasChanged = true;
                    }
                }
                break;
            }
            if (hasChanged) curr = new int[]{res[count - 1][0] + 1, res[count - 1][1]};

            //down
            hasChanged = false;
            r = curr[0];
            c = curr[1];
            for (int i = r; i < r + step; i++) {
                if (cellExists(i, c, rows, cols)) {
                    if (!visited[i][c]) {
                        visited[i][c] = true;
                        res[count++] = new int[]{i, c};
                        hasChanged = true;
                    }
                }
                break;
            }
            if (hasChanged) curr = new int[]{res[count - 1][0], res[count - 1][1] - 1};

            step++;
            //left
            hasChanged = false;
            r = curr[0];
            c = curr[1];
            for (int i = c; i > c - step; i--) {
                if (cellExists(r, i, rows, cols)) {
                    if (!visited[r][i]) {
                        visited[r][i] = true;
                        res[count++] = new int[]{r, i};
                        hasChanged = true;
                    }
                }
                break;
            }
            if (hasChanged) curr = new int[]{res[count - 1][0] - 1, res[count - 1][1]};

            //up
            hasChanged = false;
            r = curr[0];
            c = curr[1];
            for (int i = r; i > r - step; i--) {
                if (cellExists(i, c, rows, cols)) {
                    if (!visited[i][c]) {
                        visited[i][c] = true;
                        res[count++] = new int[]{i, c};
                        hasChanged = true;
                    }
                }
            }
            if (hasChanged) curr = res[count - 1];
        }
        return res;
    }

    static boolean cellExists(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
