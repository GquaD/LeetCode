package LeetCode;

public class Problem883 {
    //https://leetcode.com/problems/projection-area-of-3d-shapes/
    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][] {
                {1,2},
                {3,4}
        }));
        System.out.println(projectionArea(new int[][] {
                {2}
        }));
        System.out.println(projectionArea(new int[][] {
                {1,0},
                {0,2}
        }));
    }

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Projection Area of 3D Shapes.
    //Memory Usage: 44.4 MB, less than 63.06% of Java online submissions for Projection Area of 3D Shapes.
    static int projectionArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += findMaxForRow(i, grid);
        }

        for (int i = 0; i < grid.length; i++) {
            sum += findMaxForColumn(i, grid);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static int findMaxForColumn(int col, int[][] matrix) {
        int max = matrix[0][col];
        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][col]) {
                max = matrix[i][col];
            }
        }
        return max;
    }

    private static int findMaxForRow(int row, int[][] matrix) {
        int min = matrix[row][0];
        for (int i = 1; i < matrix[row].length; i++) {
            if (min < matrix[row][i]) {
                min = matrix[row][i];
            }
        }
        return min;
    }
}
