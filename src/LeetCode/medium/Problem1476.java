package LeetCode.medium;

public class Problem1476 {
    //https://leetcode.com/problems/subrectangle-queries/

    //Runtime: 60 ms, faster than 5.48% of Java online submissions for Subrectangle Queries.
    //Memory Usage: 56 MB, less than 32.10% of Java online submissions for Subrectangle Queries.
    static class SubrectangleQueries {
        int[][] rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2 ; j++) {
                    rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }
}
