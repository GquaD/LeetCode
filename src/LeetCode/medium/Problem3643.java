package LeetCode.medium;

public class Problem3643 {
    //5min

    //https://leetcode.com/problems/flip-square-submatrix-vertically/solutions/7610660/java-0ms-solution-by-tbekpro-6r3o/
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //47.46
    //MB
    //Beats
    //63.12%
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        if (k == 1)
            return grid;

        for (int c = y; c < y + k; c++) {
            for (int r = x; r < x + (k / 2); r++) {
                int cur = grid[r][c];
                grid[r][c] = grid[x + k - 1 - (r - x)][c];
                grid[x + k - 1 - (r - x)][c] = cur;
            }
        }
        return grid;
    }
}
