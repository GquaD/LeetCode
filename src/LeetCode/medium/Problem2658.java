package LeetCode.medium;

public class Problem2658 {
    //https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
    public static void main(String[] args) {
        System.out.println(findMaxFish(new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}}));
        System.out.println(findMaxFish(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,0},{1,0,0,1}}));
        System.out.println(findMaxFish(new int[][]{{0,2,1,0},{4,0,1,3},{1,0,0,4},{0,3,2,0}}));
        System.out.println(findMaxFish(new int[][]{{0,2,1,1},{4,0,1,3},{1,0,0,4},{0,3,2,0}}));
    }

    //https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/solutions/3666202/java-dfs-boolean-array-of-visited-cells/
    //20-25 min
    //Runtime
    //8 ms
    //Beats
    //37.14%
    //Memory
    //44 MB
    //Beats
    //7.21%
    static int findMaxFish(int[][] grid) {
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < visited.length; i++) for (int j = 0; j < visited[i].length; j++) if (grid[i][j] == 0) visited[i][j] = true;
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (visited[i][j]) continue;
                    int fish = dfs(i, j, grid, visited, directions);
                    max = Math.max(fish, max);
                }
            }
            return max;
    }

    private static int dfs(int r, int c, int[][] grid, boolean[][] visited, int[][] directions) {
        if (!cellExists(r, c, grid)) return 0;

        if (visited[r][c]) return 0;
        visited[r][c] = true;
        int sum = grid[r][c];
        for (int[] dir : directions) {
            sum += dfs(r + dir[0], c + dir[1], grid, visited, directions);
        }
        return sum;
    }

    static boolean cellExists(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
