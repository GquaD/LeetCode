package LeetCode.medium;

public class Problem861 {
    //https://leetcode.com/problems/score-after-flipping-matrix/
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        }));
        System.out.println(matrixScore(new int[][]{
                {0}
        }));
        System.out.println(matrixScore(new int[][]{
                {0},
                {1}
        }));
        System.out.println(matrixScore(new int[][]{
                {0,1},
                {1,1}
        }));
        System.out.println(matrixScore(new int[][]{
                {1,1},
                {0,0},
                {1,0},
                {1,0},
                {1,1}
        })); //13
    }

    //Runtime: 3 ms, faster than 18.75% of Java online submissions for Score After Flipping Matrix.
    //Memory Usage: 42.7 MB, less than 15.44% of Java online submissions for Score After Flipping Matrix.
    static int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }
        for (int i = 1; i < cols; i++) {
            if (colHasLessOnes(grid, i)) {
                flipCol(grid, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j]);
            }
            sum += fromBinaryToTen(sb.toString());
            sb.setLength(0);
        }
        return sum;
    }

    private static boolean colHasLessOnes(int[][] grid, int col) {
        int countZeros = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0) {
                countZeros++;
            }
        }
        return countZeros > grid.length - countZeros;
    }

    private static void flipRow(int[][] grid, int row) {
        for (int i = 0; i < grid[row].length; i++) {
            if (grid[row][i] == 0) {
                grid[row][i] = 1;
            } else {
                grid[row][i] = 0;
            }
        }
    }

    static int matrixScore1(int[][] grid) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        if (grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                sum++;
            }
            return sum;
        }
        int length = grid.length - 1;
        if (length == 0) {
            length++;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    flipCol(grid, j);
                }
            }

            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);
            }

            sum += fromBinaryToTen(sb.toString());
            sb.setLength(0);
        }
        //max val for last row by flipping horizontally
        if (grid[grid.length - 1][0] == 0) {
            for (int i = 0; i < grid[0].length; i++) {
                int val = grid[grid.length - 1][i];
                val = val == 0 ? 1 : 0;
                grid[grid.length - 1][i] = val;
            }
        }
        if (grid.length > 1) {
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[grid.length - 1][j]);
            }

            sum += fromBinaryToTen(sb.toString());
        }
        return sum;
    }

    private static int fromBinaryToTen(String binary) {
        int pow = 0;
        int sum = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            sum += Integer.parseInt(binary.charAt(i) + "") * Math.pow(2, pow++);
        }
        return sum;
    }

    private static void flipCol(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 0) {
                grid[i][col] = 1;
            } else {
                grid[i][col] = 0;
            }
        }
    }
}
