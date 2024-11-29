package LeetCode.medium;

public class Problem361 {
    //https://leetcode.com/problems/bomb-enemy
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/bomb-enemy/solutions/6094544/java-o-n-solution/
    //10min
    //Runtime
    //8
    //ms
    //Beats
    //73.98%
    //Analyze Complexity
    //Memory
    //63.26
    //MB
    //Beats
    //25.67%
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] arr = new int[m][n];
        //from left to right
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == '0') {
                    arr[i][j] += sum;
                } else if (c == 'E') {
                    sum++;
                } else {
                    sum = 0;
                }
            }
        }
        //top to bottom
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                char c = grid[i][j];
                if (c == '0') {
                    arr[i][j] += sum;
                } else if (c == 'E') {
                    sum++;
                } else {
                    sum = 0;
                }
            }
        }

        //right to left
        for (int i = m - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                char c = grid[i][j];
                if (c == '0') {
                    arr[i][j] += sum;
                } else if (c == 'E') {
                    sum++;
                } else {
                    sum = 0;
                }
            }
        }

        //bottom to top
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = m - 1; i >= 0; i--) {
                char c = grid[i][j];
                if (c == '0') {
                    arr[i][j] += sum;
                } else if (c == 'E') {
                    sum++;
                } else {
                    sum = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        return max;
    }
}
