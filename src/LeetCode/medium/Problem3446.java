package LeetCode.medium;

import java.util.*;

public class Problem3446 {
    //https://leetcode.com/problems/sort-matrix-by-diagonals
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sort-matrix-by-diagonals/solutions/6421829/java-solution-by-tbekpro-avex/
    //25min
    //Runtime
    //5
    //ms
    //Beats
    //63.69%
    //Analyze Complexity
    //Memory
    //45.64
    //MB
    //Beats
    //60.28%
    public int[][] sortMatrix(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int n = grid.length, row = 0, col = n;

        for (int i = 0; i < n - 1; i++) {
            int r = row, c = col - 1;
            while (cellExists(r, c, n)) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list);
            int idx = 0;
            r = row;
            c = col - 1;
            while(cellExists(r, c, n)) {
                grid[r][c] = list.get(idx++);
                r++;
                c++;
            }
            col--;
            list.clear();
        }

        row = 0;
        col = 0;
        for (int i = 0; i < n; i++) {
            int r = row, c = col;
            while (cellExists(r, c, n)) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list, Comparator.reverseOrder());
            int idx = 0;
            r = row;
            c = col;
            while(cellExists(r, c, n)) {
                grid[r][c] = list.get(idx++);
                r++;
                c++;
            }
            row++;
            list.clear();
        }
        return grid;
    }

    private boolean cellExists(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
