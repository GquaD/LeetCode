package LeetCode.medium;

public class Problem48 {
    //https://leetcode.com/problems/rotate-image/
    public static void main(String[] args) {
        rotate(new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        });
    }


    //with help
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.78
    //MB
    //Beats
    //52.92%
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    //https://leetcode.com/problems/rotate-image/discuss/2575946/Java-Solution
    //Runtime: 1 ms, faster than 9.22% of Java online submissions for Rotate Image.
    //Memory Usage: 43 MB, less than 27.23% of Java online submissions for Rotate Image.
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
        return;
    }
}
