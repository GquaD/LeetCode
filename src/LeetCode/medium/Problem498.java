package LeetCode.medium;

import java.util.Arrays;

public class Problem498 {
    //https://leetcode.com/problems/diagonal-traverse/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));
    }

    //https://leetcode.com/problems/diagonal-traverse/solutions/4171706/java/
    //10-15min
    //Runtime
    //347 ms
    //Beats
    //5.1%
    //Memory
    //46.3 MB
    //Beats
    //31.75%
    static int[] findDiagonalOrder(int[][] mat) {
        boolean isIncreasing = true;
        int r = 0, c = 0, m = mat.length, n = mat[0].length, i = 0;
        int[] arr = new int[m * n];
        while (i < arr.length) {
            if (isIncreasing) {
                isIncreasing = false;
                while (r >= 0) {
                    if (cellExists(r, c, mat)) arr[i++] = mat[r][c];
                    r--;
                    c++;
                }
                r = Math.max(r, 0);
            } else {
                isIncreasing = true;
                while (c >= 0) {
                    if (cellExists(r, c, mat)) arr[i++] = mat[r][c];
                    r++;
                    c--;
                }
                c = Math.max(c, 0);
            }
        }
        return arr;
    }

    static boolean cellExists(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
