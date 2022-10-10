package LeetCode.medium;

public class Problem2428 {
    //https://leetcode.com/problems/maximum-sum-of-an-hourglass/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-sum-of-an-hourglass/solutions/2681803/java-straighforward-approach/
    //10 mins
    //Runtime
    //19 ms
    //Beats
    //21.20%
    //Memory
    //54.5 MB
    //Beats
    //20.98%
    static int maxSum(int[][] grid) {
        int max = -1, m = grid.length, n = grid[0].length;
        for (int row = 0; row < m - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                int temp = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
                temp += grid[row + 1][col + 1];
                temp += grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }
}
