package LeetCode.medium;

public class Problem64 {
    //https://leetcode.com/problems/minimum-path-sum/
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));

        System.out.println(minPathSum(new int[][] {
                {1,2,3},
                {4,5,6}
        }));
    }

    //https://leetcode.com/problems/minimum-path-sum/solutions/2719119/java-o-n-explained-fast-in-just-3-ms/
    //1 hour after several days break
    //Runtime
    //3 ms
    //Beats
    //71.20%
    //Memory
    //45.4 MB
    //Beats
    //80.43%
    static int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int countRows = 0, countCols = 0;
        while (countRows < r || countCols < c) {
            for (int i = 0; i < countRows; i++) {
                insertMinSum(i, countCols, grid);
            }
            for (int i = 0; i < countCols; i++) {
                insertMinSum(countRows, i, grid);
            }

            insertMinSum(countRows, countCols, grid);

            countCols++;
            countRows++;
        }
        return grid[r - 1][c - 1];
    }
    private static void insertMinSum(int row, int col, int[][] grid) {
        if (cellExists(row, col ,grid)) {
            if (cellExists(row - 1, col, grid) && cellExists(row, col - 1, grid)) {
                int val = grid[row][col];
                grid[row][col] = Math.min(grid[row - 1][col] + val, grid[row][col - 1] + val);
            } else if (cellExists(row - 1, col, grid)) {
                grid[row][col] += grid[row - 1][col];
            } else if (cellExists(row, col - 1, grid)) {
                grid[row][col] += grid[row][col - 1];
            }
        }
    }
    private static boolean cellExists(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }


    //time limit exceeded 24 out 61
    static int min;

    static int minPathSum1(int[][] grid) {
        min = Integer.MAX_VALUE;
        findMinRecursively(0, 0, grid, 0);
        return min;
    }

    private static void findMinRecursively(int row, int col, int[][] grid, int sum) {
        if (!cellExists(row, col, grid)) {
            return;
        }
        sum += grid[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (min > sum) {
                min = sum;
            }
            return;
        }
        findMinRecursively(row, col + 1, grid, sum);
        findMinRecursively(row + 1, col, grid, sum);
    }
}
