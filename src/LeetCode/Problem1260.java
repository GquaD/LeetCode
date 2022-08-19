package LeetCode;
import java.util.*;

public class Problem1260 {
    //https://leetcode.com/problems/shift-2d-grid/
    public static void main(String[] args) {
        List<List<Integer>> test = shiftGrid(new int[][]{
                {3,8,1,9},
                {19,7,2,5},
                {4,6,11,10},
                {12,0,21,13}
        }, 4);
        LeetCodeUtils.printListWithListsOfIntegers(test);

        List<List<Integer>> test1 = shiftGrid(new int[][]{
                {3,8,1,9},
                {19,7,2,5},
                {4,6,11,10},
                {12,0,21,13}
        }, 16);
        LeetCodeUtils.printListWithListsOfIntegers(test1);

        List<List<Integer>> test2 = shiftGrid(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5}
        }, 23);
        LeetCodeUtils.printListWithListsOfIntegers(test2);
    }

    //Runtime: 14 ms, faster than 24.84% of Java online submissions for Shift 2D Grid.
    //Memory Usage: 53.9 MB, less than 83.65% of Java online submissions for Shift 2D Grid.
    static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int multiply = m * n;
        if (k % multiply == 0) {
            return to2DList(grid);
        }
        k %= multiply;

        List<Integer> list = new ArrayList<>();
        List<Integer> listEnd = new ArrayList<>();

        int forEnd = multiply - k;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count++ >= forEnd) {
                    listEnd.add(grid[i][j]);
                    continue;
                }
                list.add(grid[i][j]);
            }
        }
        listEnd.addAll(list);
        count = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add(listEnd.get(count++));
            }
            res.add(temp);
        }
        return res;
    }
    static List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int multiply = m * n;
        if (k % multiply == 0) {
            return to2DList(grid);
        }

        int[][] result = new int[m][n];
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        int rowInit = k / n;
        int colInit = k % n;
        while (count < multiply) {
            List<Integer> listRow = new ArrayList<>();
            while (colInit < n) {
                listRow.add(grid[rowInit][colInit++]);
                count++;
            }
            rowInit++;
//            if (count)
            res.add(listRow);
            continue;
        }


        return res;
    }

    private static List<List<Integer>> to2DList(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>(grid[0].length);
            for (int j = 0; j < grid[0].length; j++) {
                list.add(j, grid[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
