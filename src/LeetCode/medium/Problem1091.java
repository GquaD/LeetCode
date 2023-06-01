package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem1091 {
    //https://leetcode.com/problems/shortest-path-in-binary-matrix/
    public static void main(String[] args) {

        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0}
        }));
        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        }));

        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 0}
        }));

        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 1}
        }));

        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 1},
                {1, 0}
        }));

        System.out.println(shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    //nnnn
    //Runtime
    //32 ms
    //Beats
    //18.46%
    //Memory
    //44.8 MB
    //Beats
    //23.75%
    static int shortestPathBinaryMatrix3(int[][] grid) {
        int directions[][] = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}}, n = grid.length;
        return bfs(grid, 0, 0, n - 1, n - 1, directions);
    }

    public static int bfs(int[][] grid, int yStart, int xStart, int yTarget, int xTarget, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{yStart, xStart, 1});
        while (!queue.isEmpty()) {
            int cell[] = queue.poll(), y = cell[0], x = cell[1], count = cell[2];
            if (cellExists(y, x, grid) && grid[y][x] != 1) {
                grid[y][x] = 1;
                if (y == yTarget && x == xTarget) return count;
                for (int[] dir : directions) queue.offer(new int[]{y + dir[0], x + dir[1], count + 1});
            }
        }
        return -1;
    }


    //Time Limit Exceeded
    //64 / 89
    static int result;

    static int shortestPathBinaryMatrix(int[][] grid) {
        result = Integer.MAX_VALUE;
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}}, arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        dfs(0, 0, 0, grid, directions, visited, arr);

        return result == Integer.MAX_VALUE ? -1 : result + 1;
    }

    private static void dfs(int r, int c, int score, int[][] grid, int[][] directions, boolean[][] visited, int[][] arr) {
        if (score > arr[r][c] && arr[r][c] != 0) return;
        arr[r][c] = score;
        if (r == grid.length - 1 && c == grid.length - 1) {
            result = Math.min(score, result);
            return;
        }

        visited[r][c] = true;

        if (grid[r][c] == 0) {
            for (int[] dir : directions) {
                int row = r + dir[0], col = c + dir[1];
                if (cellExists(row, col, grid) && grid[row][col] == 0 && !visited[row][col]) {
                    dfs(row, col, score + 1, grid, directions, visited, arr);
                }
            }
        }
        visited[r][c] = false;
    }

    static int shortestPathBinaryMatrix1(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int res[][] = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    int up = Integer.MAX_VALUE, diag = up, left = up;
                    if (cellExists(r - 1, c, grid)) up = res[r - 1][c];
                    if (cellExists(r - 1, c - 1, grid)) diag = res[r - 1][c - 1];
                    if (cellExists(r, c - 1, grid)) left = res[r][c - 1];
                    int min = Math.min(up, Math.min(diag, left));
                    res[r][c] = min == Integer.MAX_VALUE ? 0 : min + 1;
                } else {
                    res[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        int ans = res[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : res[n - 1][n - 1] + 1;
        return ans < n ? -1 : ans;
    }


    static boolean cellExists(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
