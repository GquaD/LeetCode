package LeetCode.easy;

public class Problem3033 {
    //https://leetcode.com/problems/modify-the-matrix
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/modify-the-matrix/solutions/6126179/java-o-mxn-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.48
    //MB
    //Beats
    //53.61%
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] cols = new int[n];
        for (int c = 0; c < n; c++) {
            int max = 0, idx = 0;
            for (int r = 0; r < m; r++) {
                max = Math.max(matrix[r][c], max);
            }
            cols[c] = max;
        }
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] == -1) {
                    matrix[r][c] = cols[c];
                }
            }
        }
        return matrix;
    }
}
