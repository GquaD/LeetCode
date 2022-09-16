package LeetCode.easy;

public class Problem1351 {
    //https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public static void main(String[] args) {

    }

    //Runtime: 2 ms, faster than 20.56% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    //Memory Usage: 48.9 MB, less than 72.63% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    static int countNegatives1(int[][] grid) {
        int count = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) count++;
                else break;
            }
        }
        return count;
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
