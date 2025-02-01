package LeetCode.medium;
import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2664 {
    //https://leetcode.com/problems/the-knights-tour/description/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(new Problem2664().tourOfKnight(5,5,0,0));
    }

    //https://leetcode.com/problems/the-knights-tour/solutions/6357263/java-solution-by-tbekpro-oreu/
    //40min
    //Runtime
    //955
    //ms
    //Beats
    //5.09%
    //Analyze Complexity
    //Memory
    //45.36
    //MB
    //Beats
    //6.78%
    private List<String> listGlobal = new ArrayList<>();
    private int[][] directions = new int[][]{{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        Set<String> set = new LinkedHashSet<>();
        set.add(r + "_" + c);
        findPath(m, n, r, c, set);

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        result[r][c] = 0;
        int count = 0;
        for (String s : listGlobal) {
            int row = s.charAt(0) - '0', col = s.charAt(2) - '0';
            result[row][col] = count++;
        }
        return result;
    }

    private void findPath(int m, int n, int r, int c, Set<String> set) {
        if (listGlobal.size() != 0) {
            return;
        }
        if (set.size() == m * n) {
            if (listGlobal.size() == 0) {
                listGlobal = new ArrayList<>(set);
            }
            return;
        }

        for (int[] coord : directions) {
            if (cellExists(m, n, r + coord[0], c + coord[1])) {
                String coor = (r + coord[0]) + "_" + (c + coord[1]);
                if (!set.contains(coor)) {
                    set.add(coor);
                    findPath(m, n, r + coord[0], c + coord[1], set);
                    set.remove(coor);
                }
            }
        }
    }

    private boolean cellExists(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
