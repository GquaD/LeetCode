package LeetCode.easy;

public class Problem892 {
    //https://leetcode.com/problems/surface-area-of-3d-shapes/
    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{
                {1,2},
                {3,4}
        }));
        System.out.println(surfaceArea(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        }));
    }

    //https://leetcode.com/problems/surface-area-of-3d-shapes/solutions/2906337/java-understandable-solution/
    //Runtime
    //7 ms
    //Beats
    //45.89%
    //Memory
    //45.4 MB
    //Beats
    //7.36%
    static int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int h = grid[i][j];
                int fullS = h > 0 ? h * 4 + 2 : 0;
                //check adjacent
                //check left
                if (cellExists(i, j - 1, grid)) {
                    if (h <= grid[i][j - 1]) {
                        fullS -= h;
                    } else {
                        fullS -= grid[i][j - 1];
                    }
                }
                if (cellExists(i - 1, j, grid)) {
                    if (h <= grid[i - 1][j]) {
                        fullS -= h;
                    } else {
                        fullS -= grid[i - 1][j];
                    }
                }
                if (cellExists(i, j + 1, grid)) {
                    if (h <= grid[i][j + 1]) {
                        fullS -= h;
                    } else {
                        fullS -= grid[i][j + 1];
                    }
                }
                if (cellExists(i + 1, j, grid)) {
                    if (h <= grid[i + 1][j]) {
                        fullS -= h;
                    } else {
                        fullS -= grid[i + 1][j];
                    }
                }
                sum += fullS;
            }
        }
        return sum;
    }

    private static boolean cellExists(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
