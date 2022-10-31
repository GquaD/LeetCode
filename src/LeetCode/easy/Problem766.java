package LeetCode.easy;

public class Problem766 {
    //https://leetcode.com/problems/toeplitz-matrix/
    public static void main(String[] args) {

    }

    //15 min
    //https://leetcode.com/problems/toeplitz-matrix/solutions/2761994/java-solution-in-just-1-ms/
    //Runtime
    //1 ms
    //Beats
    //93.83%
    //Memory
    //42.3 MB
    //Beats
    //90.11%
    static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 1 || n == 1) return true;
        int[] prev = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            prev[i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != prev[j - 1]) {
                    return false;
                }
            }
            for (int j = 0; j < n - 1; j++) {
                prev[j] = matrix[i][j];
            }
        }
        return true;
    }

    private static boolean theSameElements(int[] prev, int[] curr) {
        for (int i = 0; i < prev.length; i++) {
            if (prev[i] != curr[i]) return false;
        }
        return true;
    }
}
