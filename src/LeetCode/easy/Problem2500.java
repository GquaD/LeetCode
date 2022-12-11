package LeetCode.easy;

import java.util.Arrays;

public class Problem2500 {
    //https://leetcode.com/problems/delete-greatest-value-in-each-row/
    public static void main(String[] args) {

    }

    //less than 5 mins
    //https://leetcode.com/problems/delete-greatest-value-in-each-row/solutions/2900542/java-100-faster-solution/
    //Runtime
    //5 ms
    //Beats
    //100%
    //Memory
    //47 MB
    //Beats
    //33.33%
    static int deleteGreatestValue(int[][] grid) {
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        int sum = 0;
        for (int col = 0; col < grid[0].length; col++) {
            int max = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] > max) {
                    max = grid[row][col];
                }
            }
            sum += max;
        }
        return sum;
    }
}
