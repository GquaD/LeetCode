package LeetCode.medium;

public class Problem3239 {
    //https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/solutions/5586087/java-100-faster-solution/
    //5-10min
    //Runtime
    //8
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //111.05
    //MB
    //Beats
    //100.00%
    public int minFlips(int[][] grid) {
        int flipsRow = 0, flipsCol = 0, rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols / 2; c++) {
                if (grid[r][c] != grid[r][cols - 1 - c])
                    flipsRow++;
            }
        }

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows / 2; r++) {
                if (grid[r][c] != grid[rows - 1 - r][c])
                    flipsCol++;
            }
        }
        return Math.min(flipsRow, flipsCol);
    }
}
