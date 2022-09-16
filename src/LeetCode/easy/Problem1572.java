package LeetCode.easy;

public class Problem1572 {
    //https://leetcode.com/problems/matrix-diagonal-sum/
    public static void main(String[] args) {

    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
    //Memory Usage: 47.7 MB, less than 57.80% of Java online submissions for Matrix Diagonal Sum.
    static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[mat.length - 1 - i][i];
        }
        if (mat.length % 2 == 1) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }
}
