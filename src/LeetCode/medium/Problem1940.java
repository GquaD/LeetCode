package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1940 {
    //https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/solutions/4720809/java-o-c-rlogc-solution/
    //5-10min
    //Runtime
    //5
    //ms
    //Beats
    //70.83%
    //of users with Java
    //Memory
    //45.92
    //MB
    //Beats
    //10.42%
    //of users with Java
    static List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> res = new ArrayList<>();
        int n = arrays.length;
        for (int c = 0; c < arrays[0].length; c++) {
            int count = 1, cur = arrays[0][c];
            for (int r = 1; r < n; r++) {
                int idx = Arrays.binarySearch(arrays[r], cur);
                if (idx >= 0) count++;
            }
            if (count == n) res.add(cur);
        }
        return res;
    }
}
