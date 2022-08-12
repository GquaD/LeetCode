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

    //Runtime: 16 ms, faster than 11.53% of Java online submissions for Find Valid Matrix Given Row and Column Sums.
    //Memory Usage: 117.6 MB, less than 67.92% of Java online submissions for Find Valid Matrix Given Row and Column Sums.
    static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }
        return res;
    }


    static int[][] restoreMatrix3(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int sumRowOverall = 0, sumColOverall = 0;
        for (int i = 0; i < rowSum.length; i++) {
            sumRowOverall += rowSum[i];
        }
        for (int i = 0; i < colSum.length; i++) {
            sumColOverall += colSum[i];
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = calcCellValue(colSum[j], sumColOverall, rowSum[i], colSum.length);
            }
        }

        for (int i = 0; i < res[0].length; i++) {
            for (int j = 0; j < res.length; j++) {
                int val = calcCellValue(rowSum[j], sumRowOverall, colSum[i], rowSum.length);
                if (val != res[j][i]) {
                    res[j][i] = Math.min(val, res[j][i]);
                }
            }
        }

        return res;
    }

    private static int calcCellValue(int sum, int sumOverall, int divider, int noOfElements) {
        return round(((sum * 1.0) / sumOverall) * divider, noOfElements);
    }

    private static int round(double d, int noOfElements) {
        double floor = Math.floor(d);
        if (d - floor > (1.0 / noOfElements)) {
            return (int) Math.ceil(d);
        } else return (int) floor;
    }


    static int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
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
