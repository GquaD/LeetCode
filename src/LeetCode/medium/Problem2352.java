package LeetCode.medium;

public class Problem2352 {
    //https://leetcode.com/problems/equal-row-and-column-pairs/
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{
                {3,2,1},
                {1,7,6},
                {2,7,7}
        }));
        System.out.println(equalPairs(new int[][]{
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        }));
    }
    //https://leetcode.com/problems/equal-row-and-column-pairs/discuss/2574107/Java-Solution-Not-Using-any-map
    //Runtime: 59 ms, faster than 54.55% of Java online submissions for Equal Row and Column Pairs.
    //Memory Usage: 71.5 MB, less than 30.97% of Java online submissions for Equal Row and Column Pairs.
    static int equalPairs(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (rowEqualToCol(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean rowEqualToCol(int row, int col, int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
