package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1222 {
    //https://leetcode.com/problems/queens-that-can-attack-the-king/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(queensAttacktheKing(new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[]{0,0}));
    }

    //Runtime: 15 ms, faster than 5.16% of Java online submissions for Queens That Can Attack the King.
    //Memory Usage: 43.9 MB, less than 16.90% of Java online submissions for Queens That Can Attack the King.
    static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            set.add(queens[i][0] + "" + queens[i][1]);
        }
        //---------------------------------up     up/r   right  down/r  down  left/d  left    up/left
        int[][] directions = new int[][]{{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        for (int i = 0; i < directions.length; i++) {
            int y = king[0], x = king[1];
            y += directions[i][0];
            x += directions[i][1];
            while (cellExists(y, x, 8, 8)) {
                if (set.contains(y + "" + x)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(y);
                    list.add(x);
                    result.add(list);
                    break;
                }
                y += directions[i][0];
                x += directions[i][1];
            }
        }
        return result;
    }

    private static boolean cellExists(int row, int col, int rows, int cols) {
        return (row <= rows - 1 && row >= 0) && (col <= cols - 1 && col >= 0);
    }
}
