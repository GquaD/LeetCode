package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

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
