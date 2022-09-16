package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1030 {
    //https://leetcode.com/problems/matrix-cells-in-distance-order/submissions/
    public static void main(String[] args) {
        allCellsDistOrder(1,2,0,0);
    }

    //Runtime: 45 ms, faster than 7.51% of Java online submissions for Matrix Cells in Distance Order.
    //Memory Usage: 67.8 MB, less than 76.14% of Java online submissions for Matrix Cells in Distance Order.
    static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Pair pair = new Pair();
                pair.distance = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                pair.coordinates = new int[] {i, j};
                list.add(pair);
            }
        }
        list = list.stream().sorted((o1, o2) -> o1.distance - o2.distance).collect(Collectors.toList());
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).coordinates[0];
            res[i][1] = list.get(i).coordinates[1];
        }
        return res;
    }

    static class Pair {
        int distance;
        int[] coordinates;
    }
}
