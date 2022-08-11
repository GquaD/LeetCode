package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem1605 {
    //https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(restoreMatrix(new int[]{3, 8}, new int[]{4, 7}));
        LeetCodeUtils.print2DArray(restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8}));
        LeetCodeUtils.print2DArray(restoreMatrix(new int[]{4,12,10,1,0}, new int[]{1,0,3,16,7})); //fails
        //[4,12,10,1,0]
        //[1,0,3,16,7]
    }

    static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < res.length - 1; i++) {
            int cell = rowSum[i] / colSum.length;
            int leftSum = rowSum[i];
            for (int j = 0; j < res[0].length - 1; j++) {
                if (cell < colSum[j]) {
                    res[i][j] = cell;
                } else {
                    res[i][j] = colSum[j];
                }
                leftSum -= res[i][j];
                colSum[j] -= res[i][j];
            }
            res[i][res[i].length - 1] = leftSum;
        }
        for (int i = 0; i < colSum.length; i++) {
            res[rowSum.length - 1][i] = colSum[i];
        }
        //return res;
        int left = colSum[colSum.length - 1];
        for (int i = 0; i < rowSum.length - 1; i++) {
            left -= res[i][colSum.length - 1];
        }

        res[rowSum.length - 1][colSum.length - 1] = left;
        return res;
    }

    static int[][] restoreMatrix1(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < res.length; i++) {
            int cell = rowSum[i] / colSum.length;
            int leftSum = rowSum[i];
            for (int j = 0; j < res[0].length - 1; j++) {
                if (cell < colSum[j]) {
                    res[i][j] = cell;
                } else {
                    res[i][j] = colSum[j] - res[i - 1][j];
                }
                leftSum -= res[i][j];
            }
            res[i][res[i].length - 1] = leftSum;
        }
        return res;
    }
}
