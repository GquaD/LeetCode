package LeetCode.medium;

public class Problem695 {
    //https://leetcode.com/problems/max-area-of-island/
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        })); //4
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        }));
        System.out.println(maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    //1 hour
    //Runtime: 9 ms, faster than 13.36% of Java online submissions for Max Area of Island.
    //Memory Usage: 47.1 MB, less than 67.80% of Java online submissions for Max Area of Island.
    static int maxArea;
    static int tempArea;

    static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        maxArea = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    tempArea = 0;
                    traverseGrid(grid, visited, i, j);
                }
            }
        }
        return maxArea;
    }

    private static void traverseGrid(int[][] grid, boolean[][] visited, int row, int col) {
        if (!cellExist(row, col, grid)) {
            return;
        }

        visited[row][col] = true;
        tempArea++;

        if (isFourDirectionsBusy(grid, visited, row, col)) {
            maxArea = Math.max(maxArea, tempArea);
            return;
        }

        //right
        if (cellExist(row, col + 1, grid) && !visited[row][col + 1]) {
            traverseGrid(grid, visited, row, col + 1);
        }
        //down
        if (cellExist(row + 1, col, grid) && !visited[row + 1][col]) {
            traverseGrid(grid, visited, row + 1, col);
        }
        //left
        if (cellExist(row, col - 1, grid) && !visited[row][col - 1]) {
            traverseGrid(grid, visited, row, col - 1);
        }
        //up
        if (cellExist(row - 1, col, grid) && !visited[row - 1][col]) {
            traverseGrid(grid, visited, row - 1, col);
        }
        //visited[row][col] = false;
    }

    private static boolean isFourDirectionsBusy(int[][] grid, boolean[][] visited, int row, int col) {
        int count = 0;
        if (!cellExist(row, col + 1, grid) || visited[row][col + 1]) {
            count++;
        }
        //down
        if (!cellExist(row + 1, col, grid) || visited[row + 1][col]) {
            count++;
        }
        //left
        if (!cellExist(row, col - 1, grid) || visited[row][col - 1]) {
            count++;
        }
        //up
        if (!cellExist(row - 1, col, grid) || visited[row - 1][col]) {
            count++;
        }
        return count == 4;
    }

    private static boolean cellExist(int row, int col, int[][] grid) {
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0) && grid[row][col] != 0;
    }

    /*if (row == rowEnd && col == colEnd) {
            visited[row][col] = true;
            if (allVisited(visited)) {
                area++;
                maxArea = area;
            }
            visited[row][col] = false;
            return;
        }*/
}
