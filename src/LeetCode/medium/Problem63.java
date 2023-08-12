package LeetCode.medium;

public class Problem63 {
    //https://leetcode.com/problems/unique-paths-ii/
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0},
                {0, 1}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));

        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        }));
    }


    //https://leetcode.com/problems/unique-paths-ii/solutions/3899969/java-o-n-meme/
    //Runtime
    //1 ms
    //Beats
    //17.1%
    //Memory
    //40.4 MB
    //Beats
    //90.18%
    static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (rows == 1 && cols == 1) return grid[0][0] == 0 ? 1 : 0;
        if (grid[rows - 1][cols - 1] == 1) return 0;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;


        for (int c = 0; c < cols; c++) {
            if (cellExist(0, c - 1, grid) && grid[0][c - 1] == 0) {
                dp[0][c] += dp[0][c - 1];
            }
        }

        for (int r = 0; r < rows; r++) {
            if (cellExist(r - 1, 0, grid) && grid[r - 1][0] == 0) {
                dp[r][0] += dp[r - 1][0];
            }
        }


        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (cellExist(r - 1, c, grid) && grid[r - 1][c] == 0) {
                    dp[r][c] += dp[r - 1][c];
                }

                if (cellExist(r, c - 1, grid) && grid[r][c - 1] == 0) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    //time limit exceeded on 30/41

    static int count;
    static int rowEnd;
    static int colEnd;

    static int uniquePathsWithObstacles1(int[][] grid) {
        count = 0;
        int m = grid.length, n = grid[0].length;

        Coordinates coordinates = new Coordinates();
        findStartAndEndPositions(coordinates, grid);
        rowEnd = coordinates.yEnd;
        colEnd = coordinates.xEnd;

        if (coordinates.xStart == coordinates.xEnd && coordinates.yStart == coordinates.yEnd) {
            return grid[0][0] == 0 ? 1 : 0;
        }

        boolean[][] visited = new boolean[m][n];
        makeAllObstaclesVisited(visited, grid);

        traverseGrid(grid, visited, coordinates.yStart, coordinates.xStart);
        return count;
    }

    private static void traverseGrid(int[][] grid, boolean[][] visited, int row, int col) {
        if (row == rowEnd && col == colEnd) {
            visited[row][col] = true;
            count++;
            visited[row][col] = false;
            return;
        }

        if (!cellExist(row, col, grid) || visited[row][col]) return;

        visited[row][col] = true;

        //right
        if (cellExist(row, col + 1, grid) && !visited[row][col + 1]) {
            traverseGrid(grid, visited, row, col + 1);
        }
        //down
        if (cellExist(row + 1, col, grid) && !visited[row + 1][col]) {
            traverseGrid(grid, visited, row + 1, col);
        }
        /*//left
        if (cellExist(row, col - 1, grid) && !visited[row][col - 1]) {
            traverseGrid(grid, visited, row, col - 1);
        }
        //up
        if (cellExist(row - 1, col, grid) && !visited[row - 1][col]) {
            traverseGrid(grid, visited, row - 1, col);
        }*/
        visited[row][col] = false;
    }

    private static void makeAllObstaclesVisited(boolean[][] visited, int[][] grid) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }
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
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0) && grid[row][col] != 1;
    }

    private static void findStartAndEndPositions(Coordinates coordinates, int[][] grid) {
        coordinates.xStart = 0;
        coordinates.yStart = 0;
        coordinates.xEnd = grid[0].length - 1;
        coordinates.yEnd = grid.length - 1;
    }

    static class Coordinates {
        int xStart, yStart, xEnd, yEnd;

        public Coordinates() {
            xStart = yStart = xEnd = yEnd = -1;
        }
    }

/*

    static HashMap<String, Integer> map;

    public int uniquePaths(int[][] obstacleGrid) {
        map = new HashMap<>();
        grid = obstacleGrid;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return anotherCalc(m, n);
    }


    private static boolean cellExists(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    int anotherCalcNew(int m, int n) {
        String key = m + "" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (cellExists(m, n, grid) && grid[m][n] == 1) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        if (m == 2) {
            return n;
        }

        if (n == 2) {
            return m;
        }

        int result = anotherCalcNew(m, n - 1) + anotherCalcNew(m - 1, n);
        if (!map.containsKey(key)) {
            map.put(key, result);
        }
        return result;
    }


    static HashMap<String, Integer> cache;
    static int[][] grid;

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache = new HashMap<>();
        grid = obstacleGrid;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int sum = anotherCalc(m, n);
        int sumNotLegit = 0;
        if (m > 1 && n > 1) {
            cache.put("11", 2);
        }
        Set<String> setObstacles = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    setObstacles.add(i + "" + j);
                }
            }
        }
        for (String key : cache.keySet()) {
            if (setObstacles.contains(key)) {
                sumNotLegit += cache.get(key);
            }
        }
        return sum - sumNotLegit;
    }

    static int anotherCalc(int m, int n) {
        String key = m + "" + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (m == 1 || n == 1) {
            if (cache.containsKey(key)) {
                cache.put(key, cache.get(key) + 1);
            } else {
                cache.put(key, 1);
            }
            return 1;
        }

        if (m == 2) {
            if (cache.containsKey(key)) {
                cache.put(key, cache.get(key) + n);
            } else {
                cache.put(key, n);
            }
            return n;
        }

        if (n == 2) {
            if (cache.containsKey(key)) {
                cache.put(key, cache.get(key) + m);
            } else {
                cache.put(key, m);
            }
            return m;
        }

        int result = anotherCalc(m, n - 1) + anotherCalc(m - 1, n);
        if (!cache.containsKey(key)) {
            cache.put(key, result);
        }
        return result;
    }*/
}
