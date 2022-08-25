package LeetCode;

public class Problem2319 {
    //https://leetcode.com/problems/check-if-matrix-is-x-matrix/https://leetcode.com/problems/check-if-matrix-is-x-matrix/
    public static void main(String[] args) {

    }
        //https://leetcode.com/problems/check-if-matrix-is-x-matrix/discuss/2476855/Explained-Java-O(N)-solution-100-faster
    //Runtime: 1 ms, faster than 99.77% of Java online submissions for Check if Matrix Is X-Matrix.
    //Memory Usage: 43.1 MB, less than 93.39% of Java online submissions for Check if Matrix Is X-Matrix.
    static boolean checkXMatrix(int[][] grid) {
        int x = grid.length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i + j == x - 1 || i == j) { //coordinates of diagonal cells
                    if (grid[i][j] == 0) {
                        return false;
                    }
                    continue;
                } else if (grid[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
