package LeetCode.easy;

public class Problem3127 {
    //https://leetcode.com/problems/make-a-square-with-the-same-color
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.53
    //MB
    //Beats
    //74.33%
    public boolean canMakeSquare(char[][] grid) {
        int w = 0, b = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'W') w++;
                else b++;
                if (grid[i+1][j] == 'W') w++;
                else b++;
                if (grid[i][j+1] == 'W') w++;
                else b++;
                if (grid[i+1][j+1] == 'W') w++;
                else b++;
                if (w > 2 || b > 2) return true;
                w = 0;
                b = 0;
            }
        }
        return false;
    }
}
