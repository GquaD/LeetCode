package LeetCode.easy;

public class Problem3142 {
    //https://leetcode.com/problems/check-if-grid-satisfies-conditions
    public static void main(String[] args) {

    }

    //5-10min
    //Runtime
    //1
    //ms
    //Beats
    //93.92%
    //Analyze Complexity
    //Memory
    //43.96
    //MB
    //Beats
    //98.65%
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                int a = grid[i][j], b = grid[i + 1][j], c = grid[i][j + 1];
                if (a != b || a == c) return false;
            }
        }
        for (int i = 0; i < grid[0].length - 1; i++) {
            if (grid[grid.length - 1][i] == grid[grid.length - 1][i + 1]) return false;
        }
        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][grid[0].length - 1] != grid[i + 1][grid[0].length - 1]) return false;
        }
        return true;
    }
}
