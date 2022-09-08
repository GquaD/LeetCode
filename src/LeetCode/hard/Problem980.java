package LeetCode.hard;

public class Problem980 {
    //https://leetcode.com/problems/unique-paths-iii/
    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 2}
        }));
        System.out.println(uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        }));
        System.out.println(uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        }));
    }

    //Runtime: 1 ms, faster than 91.25% of Java online submissions for Unique Paths III.
    //Memory Usage: 41.1 MB, less than 78.25% of Java online submissions for Unique Paths III.

    static int count;

    static int uniquePathsIII(int[][] grid) {
        count = 0;
        int m = grid.length, n = grid[0].length;

        Coordinates coordinates = new Coordinates();
        findStartAndEndPositions(coordinates, grid);

        boolean[][] visited = new boolean[m][n];
        makeAllObstaclesVisited(visited, grid);
        /*//making true the finish cell so that it will be obstacle, too
        visited[coordinates.yEnd][coordinates.xStart] = true;*/

        traverseGrid(grid, visited, coordinates, coordinates.yStart, coordinates.xStart);
        return count;
    }

    private static void makeAllObstaclesVisited(boolean[][] visited, int[][] grid) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private static void traverseGrid(int[][] grid, boolean[][] visited, Coordinates coordinates, int row, int col) {
        if (row == coordinates.yEnd && col == coordinates.xEnd) {
            visited[row][col] = true;
            if (allVisited(visited)) {
                count++;
            }
            visited[row][col] = false;

            return;
        }

        if (!cellExist(row, col, grid) || visited[row][col]) return;

        visited[row][col] = true;

        //right
        if (cellExist(row, col + 1, grid) && !visited[row][col + 1]) {
            traverseGrid(grid, visited, coordinates, row, col + 1);
        }
        //down
        if (cellExist(row + 1, col, grid) && !visited[row + 1][col]) {
            traverseGrid(grid, visited, coordinates, row + 1, col);
        }
        //left
        if (cellExist(row, col - 1, grid) && !visited[row][col - 1]) {
            traverseGrid(grid, visited, coordinates, row, col - 1);
        }
        //up
        if (cellExist(row - 1, col, grid) && !visited[row - 1][col]) {
            traverseGrid(grid, visited, coordinates, row - 1, col);
        }
        visited[row][col] = false;
    }

    private static boolean allVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }

    private static boolean cellExist(int row, int col, int[][] grid) {
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0) && grid[row][col] != -1;
    }

    private static void findStartAndEndPositions(Coordinates coordinates, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    coordinates.xStart = j;
                    coordinates.yStart = i;
                    if (coordinates.xEnd != -1) {
                        break;
                    }
                }
                if (grid[i][j] == 2) {
                    coordinates.xEnd = j;
                    coordinates.yEnd = i;
                    if (coordinates.xStart != -1) {
                        break;
                    }
                }
            }
        }
    }

    static class Coordinates {
        int xStart, yStart, xEnd, yEnd;

        public Coordinates(int xStart, int yStart, int xEnd, int yEnd) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.xEnd = xEnd;
            this.yEnd = yEnd;
        }

        public Coordinates() {
            xStart = yStart = xEnd = yEnd = -1;
        }
    }
}
