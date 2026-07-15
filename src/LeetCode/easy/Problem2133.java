package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2133 {
    //5min

    //Runtime
    //21
    //ms
    //Beats
    //61.95%
    //Memory
    //47.43
    //MB
    //Beats
    //97.37%

    public boolean checkValid(int[][] matrix) {
        Set<Integer> set = new HashSet<>(), set1 = new HashSet<>();

        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                set.add(matrix[i][j]);
                set1.add(matrix[j][i]);
            }
            if (set.size() != r || set1.size() != r) return false;
            set.clear();
            set1.clear();
        }
        return true;
    }
}
