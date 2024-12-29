package LeetCode.easy;

public class Problem3402 {
    //https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/solutions/6201903/java-100-100-solution-by-tbekpro-gbly/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.21
    //MB
    //Beats
    //100.00%
    public int minimumOperations(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;
        for (int c = 0; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                int a = grid[r - 1][c], b = grid[r][c];
                if (a >= b) {
                    count += a - b + 1;
                    grid[r][c] = a + 1;
                }
            }
        }
        return count;
    }
}
