package LeetCode.easy;

import LeetCode.LeetCodeUtils;

public class Problem566 {
    //https://leetcode.com/problems/reshape-the-matrix/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(matrixReshape(new int[][]{
                {1,2},
                {3,4}
        }, 1, 4));
        LeetCodeUtils.print2DArray(matrixReshape(new int[][]{
                {1,2,3,4}
        }, 2, 2));
    }

    //https://leetcode.com/problems/reshape-the-matrix/solutions/2835288/java-o-n-1ms-solution/
    //Runtime
    //1 ms
    //Beats
    //88.86%
    //Memory
    //50.7 MB
    //Beats
    //44.60%
    static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        int count = 0;
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = mat[count / n][count % n];
                count++;
            }
        }
        return arr;
    }
}
