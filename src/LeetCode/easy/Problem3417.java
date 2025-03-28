package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3417 {
    //https://leetcode.com/problems/zigzag-grid-traversal-with-skip
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/zigzag-grid-traversal-with-skip/solutions/6589624/java-on-solution-explained-by-tbekpro-53wx/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.26
    //MB
    //Beats
    //97.58%
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int count = 0, m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            if (r % 2 == 0) {
                for (int c = 0; c < n; c++) {
                    if (count % 2 == 0) {
                        list.add(grid[r][c]);
                    }
                    count++;
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    if (count % 2 == 0) {
                        list.add(grid[r][c]);
                    }
                    count++;
                }
            }
        }
        return list;
    }
}
