package LeetCode.medium;

import java.util.Arrays;

public class Problem1198 {
    //https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-smallest-common-element-in-all-rows/solutions/4701953/java-100-faster-binary-search/
    //5-10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //67.29
    //MB
    //Beats
    //71.00%
    //of users with Java
    static int smallestCommonElement(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        for (int c = 0; c < col; c++) {
            int n = mat[0][c], count = 1;
            for (int r = 1; r < row; r++) {
                int idx = Arrays.binarySearch(mat[r], n);
                if (idx < 0) break;
                count++;
            }
            if (count == row) return n;
        }
        return -1;
    }
}
