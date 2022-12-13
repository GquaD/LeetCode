package LeetCode.easy;

public class Problem867 {
    //https://leetcode.com/problems/transpose-matrix/
    public static void main(String[] args) {

    }

    //
    //5 min
    //Runtime
    //4 ms
    //Beats
    //14.56%
    //Memory
    //48.7 MB
    //Beats
    //40.83%
    static int[][] transpose(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[][] res = new int[c][r];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                res[col][row] = mat[row][col];
            }
        }
        return res;
    }
}
