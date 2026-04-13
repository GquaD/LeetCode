package LeetCode.easy;

public class Problem3898 {
    //2min
    //https://leetcode.com/problems/find-the-degree-of-each-vertex/
    //Runtime
    //3
    //ms
    //Beats
    //-%
    //Memory
    //48.07
    //MB
    //Beats
    //100.00%
    public int[] findDegrees(int[][] matrix) {
        int arr[] = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    arr[i]++;
                }
            }
        }
        return arr;
    }
}
