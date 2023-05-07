package LeetCode.easy;

public class Problem2022 {
    //https://leetcode.com/problems/convert-1d-array-into-2d-array/
    public static void main(String[] args) {

    }

    //purum pum purum
    //https://leetcode.com/problems/convert-1d-array-into-2d-array/solutions/3492256/java-4-line-solution/
    //5 min
    //Runtime
    //6 ms
    //Beats
    //29.86%
    //Memory
    //52.6 MB
    //Beats
    //16.5%
    static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[][]{};
        int[][] arr = new int[m][n];
        for (int i = 0; i < original.length; i++) arr[i / n][i % n] = original[i];
        return arr;
    }
}
