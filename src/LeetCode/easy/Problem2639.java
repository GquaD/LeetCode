package LeetCode.easy;

import java.util.Arrays;

public class Problem2639 {
    //https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findColumnWidth(new int[][]{{1}, {22}, {333}})));
        System.out.println(Arrays.toString(findColumnWidth(new int[][]{{-15, 1}, {22, 7}, {5,6,-2}})));
    }

    //10 min
    //Runtime
    //7 ms
    //Beats
    //56.58%
    //Memory
    //43.9 MB
    //Beats
    //55.91%
    static int[] findColumnWidth(int[][] grid) {
        int len = grid[0].length;
        for (int[] n : grid) len = Math.max(len, n.length);
        int[] arr = new int[len];
        for (int r = 0; r < grid.length; r++) for (int c = 0; c < grid[r].length; c++) arr[c] = Math.max(arr[c], Integer.toString(grid[r][c]).length());
        return arr;
    }

    static int[] findColumnWidth1(int[][] grid) {
        int len = grid[0].length;
        for (int[] n : grid) len = Math.max(len, n.length);
        int[] arr = new int[len];
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                arr[c] = Math.max(arr[c], (grid[r][c] + "").length());
            }
        }
        return arr;
    }
}
