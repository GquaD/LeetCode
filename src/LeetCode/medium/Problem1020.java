package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1020 {
    //https://leetcode.com/problems/number-of-enclaves/
    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}}));
    }

    //https://leetcode.com/problems/number-of-enclaves/solutions/3389536/java-bfs-solution/
    //5 min since used my solution from Problem1254
    //Runtime
    //55 ms
    //Beats
    //5.13%
    //Memory
    //50.4 MB
    //Beats
    //85.21%
    static int numEnclaves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (!visited[y][x]) {
                    if (grid[y][x] == 1) {
                        Queue<int[]> queue = new LinkedList<>();
                        boolean isClosed = true;
                        queue.add(new int[]{y, x});
                        int countCells = 0;
                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int y1 = arr[0], x1 = arr[1];
                            if (!visited[y1][x1] && grid[y1][x1] == 1) {
                                visited[y1][x1] = true;
                                countCells++;
                                List<int[]> neighbors = findNeighborsArrays(y1, x1, grid);
                                if (neighbors.size() != 4) isClosed = false;
                                queue.addAll(getZeroNotVisitedCellsArrays(neighbors, visited, grid));
                            }
                        }
                        if (isClosed)
                            count+=countCells;
                    } else {
                        visited[y][x] = true;
                    }
                }
            }
        }
        return count;
    }

    private static List<int[]> getZeroNotVisitedCellsArrays(List<int[]> neighbors, boolean[][] visited, int[][] grid) {
        int idx = 0;
        while (idx < neighbors.size()) {
            int[] arr = neighbors.get(idx);
            int y = arr[0], x = arr[1];
            if (grid[y][x] == 0 || visited[y][x]) neighbors.remove(idx);
            else idx++;
        }
        return neighbors;
    }

    private static List<int[]> findNeighborsArrays(int y, int x, int[][] grid) {
        List<int[]> list = new ArrayList<>();
        if (cellExists(y - 1, x, grid)) list.add(new int[]{y - 1, x});
        if (cellExists(y, x + 1, grid)) list.add(new int[]{y, x + 1});
        if (cellExists(y + 1, x, grid)) list.add(new int[]{y + 1, x});
        if (cellExists(y, x - 1, grid)) list.add(new int[]{y, x - 1});
        return list;
    }

    private static boolean cellExists(int row, int col, int[][] grid) {
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0);
    }
}
