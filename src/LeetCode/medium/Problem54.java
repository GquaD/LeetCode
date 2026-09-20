package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem54 {
    //https://leetcode.com/problems/spiral-matrix/description/
    public static void main(String[] args) {
        LeetCodeUtils.printList(spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        }));
    }

    //15min
    //Runtime
    //4
    //ms
    //Beats
    //0.89%
    //Memory
    //42.99
    //MB
    //Beats
    //62.51%
    public List<Integer> spiralOrder2(int[][] matrix) {
        //4 directions
        //mechanism following the directions
        //iterator checking visited and incrementing

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, x = 0, y = 0, rows = matrix.length, columns = matrix[0].length, size = rows * columns;;
        List<Integer> list = new ArrayList<>(size);
        list.add(matrix[0][0]);
        Set<String> visited = new HashSet<>();
        visited.add("0_0");

        while (visited.size() < size) {
            int x1 = directions[dir % 4][1], y1 = directions[dir % 4][0];
            String coord = (x + x1) + "_" + (y + y1);

            if (cellExists(rows, columns, x + x1, y + y1) && !visited.contains(coord)) {
                list.add(matrix[y + y1][x + x1]);
                visited.add(coord);

                y += y1;
                x += x1;
            } else {
                dir++;
            }
        }

        return list;
    }

    private boolean cellExists(int rows, int columns, int x, int y) {
        return x >= 0 && y >= 0 && y < rows && x < columns;
    }

    //https://leetcode.com/problems/spiral-matrix/solutions/2849128/java-100-faster-solution/
    //20-30 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.6 MB
    //Beats
    //82.18%
    static List<Integer> spiralOrder(int[][] matrix) {
        int y = 0, x = 0;
        boolean hasNextMove = true;
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        list.add(matrix[y][x]);
        matrix[y][x] = 101;
        while (hasNextMove) {
            boolean moveMade = false;
            while (moveExists(y, x+1, matrix)) {
                x++;
                list.add(matrix[y][x]);
                matrix[y][x] = 101;
                moveMade = true;
            }
            while (moveExists(y+1, x, matrix)) {
                y++;
                list.add(matrix[y][x]);
                matrix[y][x] = 101;
                moveMade = true;
            }
            while (moveExists(y, x-1, matrix)) {
                x--;
                list.add(matrix[y][x]);
                matrix[y][x] = 101;
                moveMade = true;
            }
            while (moveExists(y-1, x, matrix)) {
                y--;
                list.add(matrix[y][x]);
                matrix[y][x] = 101;
                moveMade = true;
            }
            if (moveMade) continue;
            hasNextMove = false;
        }
        return list;
    }

    private static boolean moveExists(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 101;
    }
}
