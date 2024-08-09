package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem840 {
    //https://leetcode.com/problems/magic-squares-in-grid

    public static void main(String[] args) {
        Problem840 problem840 = new Problem840();
        System.out.println(problem840.numMagicSquaresInside(new int[][]{
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));
    }

    //https://leetcode.com/problems/magic-squares-in-grid/solutions/5612119/java-2ms-solution/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //10.81%
    //Analyze Complexity
    //Memory
    //41.92
    //MB
    //Beats
    //11.35%
    Set<Integer> set;

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, res = 0;
        if (rows < 3 || cols < 3) return 0;

        if (set == null) {
            set = new HashSet<>();
        }
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                if (isMagicSquare(r, c, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagicSquare(int r, int c, int[][] grid) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int cur = grid[i][j];
                set.add(cur);
                if (cur < 1 || cur > 9) return false;
            }
        }
        int s = set.size();
        set.clear();
        if (s < 2) return false;
        //rows
        set.add(grid[r][c] + grid[r][c + 1] + grid[r][c + 2]);
        set.add(grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2]);
        set.add(grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2]);

        //cols
        set.add(grid[r][c] + grid[r + 1][c] + grid[r + 2][c]);
        set.add(grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1]);
        set.add(grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2]);

        //diag
        set.add(grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]);
        set.add(grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]);

        int size = set.size();
        set.clear();
        return size == 1;
    }
}
