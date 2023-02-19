package LeetCode.medium;

import java.util.Arrays;

public class Problem241 {
    //https://leetcode.com/problems/search-a-2d-matrix-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/3204826/java-2-line-o-m-log-m-solution/
    //nnnn
    //Runtime
    //5 ms
    //Beats
    //100%
    //Memory
    //48.1 MB
    //Beats
    //78.60%
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
            else return true;
        }
        return false;
    }

    //5min
    //Runtime
    //6 ms
    //Beats
    //51.8%
    //Memory
    //47.9 MB
    //Beats
    //93.79%
    static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++)
            if (Arrays.binarySearch(matrix[i], target) > -1) return true;
        return false;
    }
}
