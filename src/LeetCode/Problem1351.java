package LeetCode;

public class Problem1351 {
    //https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 50.62% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    //Memory Usage: 49.8 MB, less than 17.99% of Java online submissions for Count Negative Numbers in a Sorted Matrix.

    static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) count++;
            }
        }
        return count;
    }
}
