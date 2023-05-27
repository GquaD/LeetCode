package LeetCode.medium;

import java.util.Arrays;

public class Problem378 {
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public static void main(String[] args) {

    }

    //5 min
    //Runtime
    //11 ms
    //Beats
    //69.47%
    //Memory
    //47.1 MB
    //Beats
    //87.71%
    static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, len = n * n, arr[] = new int[len], c = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) arr[c++] = matrix[i][j];
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
