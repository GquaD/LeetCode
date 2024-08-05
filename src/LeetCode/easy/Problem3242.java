package LeetCode.easy;

public class Problem3242 {
    //https://leetcode.com/problems/design-neighbor-sum-service/
    public static void main(String[] args) {

    }


}

//5-10min
//Runtime
//18
//ms
//Beats
//50.00%
//Analyze Complexity
//Memory
//45.20
//MB
//Beats
//100.00%
class neighborSum {
    int[][] grid;
    int rows;
    public neighborSum(int[][] g) {
        grid = g;
        rows = g.length;
    }

    public int adjacentSum(int value) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                if (grid[r][c] == value) {
                    int sum = 0;
                    if (cellExists(r - 1, c)) {
                        sum += grid[r - 1][c];
                    }
                    if (cellExists(r + 1, c)) {
                        sum += grid[r + 1][c];
                    }
                    if (cellExists(r, c - 1)) {
                        sum += grid[r][c - 1];
                    }
                    if (cellExists(r, c + 1)) {
                        sum += grid[r][c + 1];
                    }
                    return sum;
                }
            }
        }
        return 0;
    }

    public int diagonalSum(int value) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                if (grid[r][c] == value) {
                    int sum = 0;
                    if (cellExists(r - 1, c - 1)) {
                        sum += grid[r - 1][c - 1];
                    }
                    if (cellExists(r + 1, c - 1)) {
                        sum += grid[r + 1][c - 1];
                    }
                    if (cellExists(r - 1, c + 1)) {
                        sum += grid[r - 1][c + 1];
                    }
                    if (cellExists(r + 1, c + 1)) {
                        sum += grid[r + 1][c + 1];
                    }
                    return sum;
                }
            }
        }
        return 0;
    }

    private boolean cellExists(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < rows;
    }
}
