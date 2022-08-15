package LeetCode.medium;

public class Problem1314 {
    //https://leetcode.com/problems/matrix-block-sum/
    public static void main(String[] args) {
        matrixBlockSum(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }, 1);
        matrixBlockSum(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }, 2);
    }

    //Runtime: 102 ms, faster than 17.16% of Java online submissions for Matrix Block Sum.
    //Memory Usage: 49.2 MB, less than 39.53% of Java online submissions for Matrix Block Sum.
    static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = countSum(mat, i, j, k);
            }
        }
        return res;
    }

    private static int countSum(int[][] mat, int row, int col, int k) {
        int rowMinIndex = row - k < 0 ? 0 : row - k;
        int rowMaxIndex = row + k > mat.length - 1 ? mat.length - 1 : row + k;
        int colMinIndex = col - k < 0 ? 0 : col - k;
        int colMaxIndex = col + k > mat[0].length - 1 ? mat[0].length - 1 : col + k;
        int sum = 0;
        for (int i = rowMinIndex; i <= rowMaxIndex ; i++) {
            for (int j = colMinIndex; j <= colMaxIndex; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
