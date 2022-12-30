package LeetCode.medium;

import java.util.Arrays;

public class Problem74 {
    //https://leetcode.com/problems/search-a-2d-matrix/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/search-a-2d-matrix/solutions/2970232/java-100-faster-solution/
    //5min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.2 MB
    //Beats
    //66.61%

    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (target == matrix[i][0] || target == matrix[i][cols - 1]) return true;
            if (target > matrix[i][0] && target < matrix[i][cols - 1]) {
                int idx = Arrays.binarySearch(matrix[i], target);
                return idx > -1;
            }
        }
        return false;
    }
}
