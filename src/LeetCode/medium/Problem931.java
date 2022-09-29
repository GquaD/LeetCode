package LeetCode.medium;

public class Problem931 {
    //https://leetcode.com/problems/minimum-falling-path-sum/
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{
                {2,1,3},
                {6,5,4},
                {7,8,9}
        }));

        System.out.println(minFallingPathSum(new int[][]{
                { 100, -42, -46, -41},
                { 31,   97,  10, -10},
                {-58,  -51,  82,  89},
                { 51,   81,  69, -51}
        })); //-36
    }


    //Runtime: 4 ms, faster than 73.32% of Java online submissions for Minimum Falling Path Sum.
    //Memory Usage: 42.3 MB, less than 99.83% of Java online submissions for Minimum Falling Path Sum.
    static int minFallingPathSum(int[][] m) {
        int len = m.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int min = Math.min(m[i - 1][Math.max(0, j - 1)], m[i - 1][Math.min(len - 1, j + 1)]);
                min = Math.min(m[i - 1][j], min);
                m[i][j] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int n : m[len - 1]) {
            if (min > n) {
                min = n;
            }
        }
        return min;
    }
    
    //time limit exceeded
    static int sumForRecursion;
    
    static int minFallingPathSum2(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            sumForRecursion = sum;
            pathsAndSums(matrix, 0, i, 0);
            if (sum > sumForRecursion) {
                sum = sumForRecursion;
            }
        }
        return sum;
    }
    private static void pathsAndSums(int[][] matrix, int row, int col, int sum) {
        if (!cellExistsHorizontally(matrix, row, col)) {
            return;
        }

        if (cellExistsHorizontally(matrix, row, col) && row >= matrix.length) {
            if (sumForRecursion > sum) {
                sumForRecursion = sum;
                return;
            }
        }

        if (!cellExists(matrix, row, col)) {
            return;
        }

        sum += matrix[row][col];

        pathsAndSums(matrix, row + 1, col - 1, sum);
        pathsAndSums(matrix, row + 1, col, sum);
        pathsAndSums(matrix, row + 1, col + 1, sum);
    }

    private static void pathsAndSums1(int[][] matrix, int row, int col, int sum) {
        if (!cellExistsHorizontally(matrix, row, col)) {
            return;
        }

        if (cellExistsHorizontally(matrix, row, col) && row >= matrix.length) {
            if (sumForRecursion > sum) {
                sumForRecursion = sum;
                return;
            }
        }

        if (!cellExists(matrix, row, col)) {
            return;
        }

        sum += matrix[row][col];

        pathsAndSums1(matrix, row + 1, col - 1, sum);
        pathsAndSums1(matrix, row + 1, col, sum);
        pathsAndSums1(matrix, row + 1, col + 1, sum);
    }

    private static boolean cellExistsHorizontally(int[][] matrix, int row, int col) {
        return col >= 0 && col < matrix[0].length;
    }

    static int minFallingPathSum1(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int col = 0; col < n; col++) {
            int sumTemp = matrix[0][col];
            int columnVar = col;
            for (int row = 1; row < n; row++) {
                int minTemp = Integer.MAX_VALUE;
                int c = columnVar - 1;
                if (cellExists(matrix, row, c) && minTemp > matrix[row][c]) {
                    minTemp = matrix[row][c];
                    columnVar = c;
                }
                c++;
                if (cellExists(matrix, row, c) && minTemp > matrix[row][c]) {
                    minTemp = matrix[row][c];
                    columnVar = c;
                }
                c++;
                if (cellExists(matrix, row, c) && minTemp > matrix[row][c]) {
                    minTemp = matrix[row][c];
                    columnVar = c;
                }
                sumTemp += minTemp;
            }

            if (minSum > sumTemp) {
                minSum = sumTemp;
            }
        }
        return minSum;
    }

    private static boolean cellExists(int[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length);
    }

}
