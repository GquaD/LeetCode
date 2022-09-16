package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem1380 {
    //https://leetcode.com/problems/lucky-numbers-in-a-matrix/
    public static void main(String[] args) {
        LeetCodeUtils.printList(luckyNumbers(new int[][]{
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        }));
        LeetCodeUtils.printList(luckyNumbers(new int[][]{
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}
        }));
        LeetCodeUtils.printList(luckyNumbers(new int[][]{
                {7, 8},
                {1, 2}
        }));
    }

    //Runtime: 3 ms, faster than 62.83% of Java online submissions for Lucky Numbers in a Matrix.
    //Memory Usage: 50.2 MB, less than 40.17% of Java online submissions for Lucky Numbers in a Matrix.
    static List<Integer> luckyNumbers(int[][] matrix) {
        int[] mins = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            mins[i] = findMinForRow(i, matrix);
        }
        int[] maxes = new int[matrix[0].length];
        for (int i = 0; i < maxes.length; i++) {
            maxes[i] = findMaxForColumn(i, matrix);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (mins[i] == matrix[i][j] && maxes[j] == matrix[i][j]) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }

    private static int findMaxForColumn(int col, int[][] matrix) {
        int max = matrix[0][col];
        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][col]) {
                max = matrix[i][col];
            }
        }
        return max;
    }

    private static int findMinForRow(int row, int[][] matrix) {
        int min = matrix[row][0];
        for (int i = 1; i < matrix[row].length; i++) {
            if (min > matrix[row][i]) {
                min = matrix[row][i];
            }
        }
        return min;
    }
}
