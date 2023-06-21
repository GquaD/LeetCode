package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.HashSet;
import java.util.Set;

public class Problem2711 {
    //https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(differenceOfDistinctValues(new int[][]{{1,2,3}, {3,1,5}, {3,2,1}}));
        System.out.println();
        LeetCodeUtils.print2DArray(differenceOfDistinctValues(new int[][]{{1}}));
    }

    //https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/solutions/3666332/java-o-n-95-faster-using-2d-arrays-as-cache-and-hashset/
    //20-25 min
    //Runtime
    //8 ms
    //Beats
    //94.56%
    //Memory
    //44.7 MB
    //Beats
    //82.32%
    static int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] arrTopLeft = new int[m][n], arrBotRight = new int[m][n];
        //for top left, bottom up
        for (int i = m - 1; i >= 0; i--) {
            int c = 0, r = i;
            Set<Integer> set = new HashSet<>();
            while (cellExists(r, c, grid)) {
                arrTopLeft[r][c] = set.size();
                set.add(grid[r++][c++]);
            }
        }

        for (int i = 1; i < n; i++) {
            int r = 0, c = i;
            Set<Integer> set = new HashSet<>();
            while (cellExists(r, c, grid)) {
                arrTopLeft[r][c] = set.size();
                set.add(grid[r++][c++]);
            }
        }

        for (int i = 0; i < n; i++) {
            int r = m - 1, c = i;
            Set<Integer> set = new HashSet<>();
            while (cellExists(r, c, grid)) {
                arrBotRight[r][c] = set.size();
                set.add(grid[r--][c--]);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            int c = n - 1, r = i;
            Set<Integer> set = new HashSet<>();
            while (cellExists(r, c, grid)) {
                arrBotRight[r][c] = set.size();
                set.add(grid[r--][c--]);
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = Math.abs(arrTopLeft[r][c] - arrBotRight[r][c]);
            }
        }
        return grid;
    }

    static boolean cellExists(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
