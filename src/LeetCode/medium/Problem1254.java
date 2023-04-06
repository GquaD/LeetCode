package LeetCode.medium;

import java.util.*;

public class Problem1254 {
    //https://leetcode.com/problems/number-of-closed-islands/description/
    public static void main(String[] args) {
        System.out.println(closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(closedIsland(new int[][]{
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 1, 0}}));
    }

    //1 hour
    //https://leetcode.com/problems/number-of-closed-islands/solutions/3385388/java-from-39ms-to-11ms/
    //Runtime
    //11 ms
    //Beats
    //5.56%
    //Memory
    //42.8 MB
    //Beats
    //69.67%
    static int closedIsland(int[][] grid) {
        //1.build adjacency map
        //2.go thru grid and if 1 - skip
        //if 0, add adjacent 0's to stack, keep visited array
        //if 0 is surrounded by 0s and 1s, then correct, else incorrect
        int rows = grid.length, cols = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (!visited[y][x]) {
                    if (grid[y][x] == 0) {
                        Queue<int[]> queue = new LinkedList<>();
                        boolean isClosed = true;
                        queue.add(new int[]{y, x});
                        while (!queue.isEmpty()) {
                            int[] arr = queue.poll();
                            int y1 = arr[0], x1 = arr[1];
                            if (!visited[y1][x1] && grid[y1][x1] == 0) {
                                visited[y1][x1] = true;
                                List<int[]> neighbors = findNeighborsArrays(y1, x1, grid);
                                if (neighbors.size() != 4) isClosed = false;
                                queue.addAll(getZeroNotVisitedCellsArrays(neighbors, visited, grid));
                            }
                        }
                        if (isClosed)
                            count++;
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
            if (grid[y][x] == 1 || visited[y][x]) neighbors.remove(idx);
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

    //Runtime
    //12 ms
    //Beats
    //5.18%
    //Memory
    //43.2 MB
    //Beats
    //34.8%
    static int closedIsland3(int[][] grid) {
        //1.build adjacency map
        //2.go thru grid and if 1 - skip
        //if 0, add adjacent 0's to stack, keep visited array
        //if 0 is surrounded by 0s and 1s, then correct, else incorrect
        int rows = grid.length, cols = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (!visited[y][x]) {
                    if (grid[y][x] == 0) {
                        Queue<Cell> queue = new LinkedList<>();
                        boolean isClosed = true;
                        queue.add(new Cell(y, x));
                        while (!queue.isEmpty()) {
                            Cell cell = queue.poll();
                            if (!visited[cell.y][cell.x] && grid[cell.y][cell.x] == 0) {
                                visited[cell.y][cell.x] = true;
                                List<Cell> neighbors1 = findNeighbors(cell.y, cell.x, grid);
                                queue.addAll(getZeroCells(neighbors1, grid));
                                if (neighbors1.size() != 4) isClosed = false;
                            }
                        }
                        if (isClosed)
                            count++;
                    } else {
                        visited[y][x] = true;
                    }
                }
            }
        }
        return count;
    }

    private static List<Cell> findNeighbors(int y, int x, int[][] grid) {
        List<Cell> list = new ArrayList<>();
        if (cellExists(y - 1, x, grid)) list.add(new Cell(y - 1, x));
        if (cellExists(y, x + 1, grid)) list.add(new Cell(y, x + 1));
        if (cellExists(y + 1, x, grid)) list.add(new Cell(y + 1, x));
        if (cellExists(y, x - 1, grid)) list.add(new Cell(y, x - 1));
        return list;
    }

    //Runtime
    //18 ms
    //Beats
    //5.3%
    //Memory
    //46.2 MB
    //Beats
    //5.86%
    static int closedIsland2(int[][] grid) {
        //1.build adjacency map
        //2.go thru grid and if 1 - skip
        //if 0, add adjacent 0's to stack, keep visited array
        //if 0 is surrounded by 0s and 1s, then correct, else incorrect
        int rows = grid.length, cols = grid[0].length;
        List<Cell>[][] adj = new List[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                List<Cell> list = new ArrayList<>();
                if (cellExists(y - 1, x, grid)) list.add(new Cell(y - 1, x)); //up
                if (cellExists(y, x + 1, grid)) list.add(new Cell(y, x + 1)); //right
                if (cellExists(y + 1, x, grid)) list.add(new Cell(y + 1, x)); //down
                if (cellExists(y, x - 1, grid)) list.add(new Cell(y, x - 1)); //left
                adj[y][x] = list;
            }
        }
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (!visited[y][x]) {
                    if (grid[y][x] == 0) {
                        Queue<Cell> queue = new LinkedList<>();
                        boolean isClosed = true;
                        queue.add(new Cell(y, x));
                        while (!queue.isEmpty()) {
                            Cell cell = queue.poll();
                            if (!visited[cell.y][cell.x] && grid[cell.y][cell.x] == 0) {
                                visited[cell.y][cell.x] = true;
                                List<Cell> neighbors1 = adj[cell.y][cell.x];
                                queue.addAll(getZeroCells(neighbors1, grid));
                                if (neighbors1.size() != 4) isClosed = false;
                            }
                        }
                        if (isClosed)
                            count++;
                    } else {
                        visited[y][x] = true;
                    }
                }
            }
        }
        return count;
    }

    //1 hour
    //Runtime
    //39 ms
    //Beats
    //5.3%
    //Memory
    //46.9 MB
    //Beats
    //5.10%
    static int closedIsland1(int[][] grid) {
        //1.build adjacency map
        //2.go thru grid and if 1 - skip
        //if 0, add adjacent 0's to stack, keep visited array
        //if 0 is surrounded by 0s and 1s, then correct, else incorrect
        int rows = grid.length, cols = grid[0].length;
        Map<String, List<Cell>> map = new HashMap<>();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                String key = y + "-" + x;
                List<Cell> list = new ArrayList<>();
                if (cellExists(y - 1, x, grid)) list.add(new Cell(y - 1, x)); //up
                if (cellExists(y, x + 1, grid)) list.add(new Cell(y, x + 1)); //right
                if (cellExists(y + 1, x, grid)) list.add(new Cell(y + 1, x)); //down
                if (cellExists(y, x - 1, grid)) list.add(new Cell(y, x - 1)); //left
                map.put(key, list);
            }
        }
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (!visited[y][x]) {
                    if (grid[y][x] == 0) {
                        Queue<Cell> queue = new LinkedList<>();
                        boolean isClosed = true;
                        queue.add(new Cell(y, x));
                        while (!queue.isEmpty()) {
                            Cell cell = queue.poll();
                            if (!visited[cell.y][cell.x] && grid[cell.y][cell.x] == 0) {
                                visited[cell.y][cell.x] = true;
                                List<Cell> neighbors1 = map.get(cell.y + "-" + cell.x);
                                if (neighbors1.size() == 4) {
                                    queue.addAll(getZeroCells(neighbors1, grid));
                                } else {
                                    queue.addAll(getZeroCells(neighbors1, grid));
                                    isClosed = false;
                                }
                            }
                        }
                        if (isClosed)
                            count++;
                    } else {
                        visited[y][x] = true;
                    }
                }
            }
        }
        return count;
    }

    private static List<Cell> getZeroCells(List<Cell> cells, int[][] grid) {
        List<Cell> res = new ArrayList<>();
        for (Cell cell : cells) if (grid[cell.y][cell.x] == 0) res.add(cell);
        return res;
    }

    private static boolean cellExists(int row, int col, int[][] grid) {
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0);
    }

    static class Cell {
        int y, x;

        public Cell(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
