package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1329 {
    //https://leetcode.com/problems/sort-the-matrix-diagonally/

    public static void main(String[] args) {
        diagonalSort(new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        });
        diagonalSort(new int[][]{
                {3,3},
                {2,2}
        });
    }
    //Runtime: 12 ms, faster than 43.30% of Java online submissions for Sort the Matrix Diagonally.
    //Memory Usage: 47.9 MB, less than 59.95% of Java online submissions for Sort the Matrix Diagonally
    static int[][] diagonalSort(int[][] mat) {
        //tempDiagonalStartCoordinates
        int x = 0, y = mat.length - 1;
        int numOfDiagonals = mat.length + mat[0].length - 1;
        List<Integer> nums;
        for (int i = 0; i < numOfDiagonals; i++) {
            nums = new ArrayList<>();
            int xTemp = x, yTemp = y;
            while (cellExist(yTemp, xTemp, mat)) {
                nums.add(mat[yTemp][xTemp]);
                yTemp++;
                xTemp++;
            }
            Collections.sort(nums);
            xTemp = x;
            yTemp = y;
            int count = 0;
            while (cellExist(yTemp, xTemp, mat)) {
                mat[yTemp][xTemp] = nums.get(count++);
                //nums.add(mat[yTemp][xTemp]);
                yTemp++;
                xTemp++;
            }
            if (y - 1 == -1) {
                x++;
            }
            y = Math.max(y - 1, 0);

        }
        return mat;
    }

    private static boolean cellExist(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
