package LeetCode.medium;

import java.util.Arrays;

public class Problem1310 {
    //https://leetcode.com/problems/xor-queries-of-a-subarray/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1,3,4,8}, new int[][]{
                {0,1},
                {1,2},
                {0,3},
                {3,3}
        })));
    }

    //Runtime: 717 ms, faster than 13.63% of Java online submissions for XOR Queries of a Subarray.
    //Memory Usage: 66.6 MB, less than 68.91% of Java online submissions for XOR Queries of a Subarray.
    static int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int xor = arr[l];
            for (int j = l + 1; j <= r; j++) {
                xor ^= arr[j];
            }
            res[i] = xor;
        }
        return res;
    }
}
