package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3546 {
    //10min

    //Runtime
    //11
    //ms
    //Beats
    //12.59%
    //Memory
    //160.34
    //MB
    //Beats
    //89.51%
    //https://leetcode.com/problems/equal-sum-grid-partition-i/solutions/7691956/java-solution-by-tbekpro-9rbc/
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        List<Long> list = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            long sum = 0;
            for (int c = 0; c < cols; c++) {
                sum += grid[r][c];
            }
            list.add(sum);
        }
        if (hasEqual(list)) return true;
        list.clear();

        for (int c = 0; c < cols; c++) {
            long sum = 0;
            for (int r = 0; r < rows; r++) {
                sum += grid[r][c];
            }
            list.add(sum);
        }

        return hasEqual(list);
    }

    private boolean hasEqual(List<Long> list) {
        long sum = 0, inc = 0;
        for (long n: list) sum += n;
        if (sum % 2 == 1) return false;
        for (long n: list) {
            inc += n;
            if (sum - inc == inc) return true;
        }

        return false;
    }
}
