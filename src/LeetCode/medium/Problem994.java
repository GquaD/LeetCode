package LeetCode.medium;
import java.util.*;

public class Problem994 {
    //https://leetcode.com/problems/rotting-oranges/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/rotting-oranges/solutions/4535811/java-bfs-o-n-solution/
    //15-20min
    //Runtime
    //10 ms
    //Beats
    //6.31%
    //Memory
    //43.6 MB
    //Beats
    //5.66%
    static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int val = grid[y][x];
                if (val == 2) {
                    q.offer(new int[]{y, x});
                }
            }
        }

        int res = 0;
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int y = q.peek()[0], x = q.poll()[1];

                if (visited.contains(y + " " + x)) continue;
                visited.add(y + " " + x);

                if (cellExists(y - 1, x, m, n) && grid[y - 1][x] == 1) {
                    grid[y - 1][x] = 2;
                    q.offer(new int[]{y - 1, x});
                }

                if (cellExists(y + 1, x, m, n) && grid[y + 1][x] == 1) {
                    grid[y + 1][x] = 2;
                    q.offer(new int[]{y + 1, x});
                }

                if (cellExists(y, x - 1, m, n) && grid[y][x - 1] == 1) {
                    grid[y][x - 1] = 2;
                    q.offer(new int[]{y, x - 1});
                }

                if (cellExists(y, x + 1, m, n) && grid[y][x + 1] == 1) {
                    grid[y][x + 1] = 2;
                    q.offer(new int[]{y, x + 1});
                }
            }
            res++;
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                int val = grid[y][x];
                if (val == 1) {
                    return -1;
                }
            }
        }

        return res > 0 ? res - 1 : res;
    }

    private static boolean cellExists(int y, int x, int m, int n) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }
}
