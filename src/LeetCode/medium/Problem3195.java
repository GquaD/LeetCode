package LeetCode.medium;

public class Problem3195 {
    //https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/solutions/5357475/java-o-n-100-faster-solution/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //196.80
    //MB
    //Beats
    //100.00%
    private int minimumArea(int[][] grid) {
        int up = 1001, left = 1001, down = -1, right = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    up = Math.min(i, up);
                    left = Math.min(j, left);
                    down = Math.max(i, up);
                    right = Math.max(j, right);
                }
            }
        }
        return (down - up + 1) * (right - left + 1);
    }
}
