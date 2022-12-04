package LeetCode.medium;

public class Problem2482 {
    //https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/solutions/2876177/java-96-faster-o-n-solution/
    //15 min
    //Runtime
    //9 ms
    //Beats
    //96.43%
    //Memory
    //144.6 MB
    //Beats
    //78.15%
    static int[][] onesMinusZeros(int[][] grid) {
        int[] onesInRows = new int[grid.length];
        int[] zerosInRows = new int[grid.length];
        int[] onesInCols = new int[grid[0].length];
        int[] zerosInCols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    onesInRows[i]++;
                    onesInCols[j]++;
                } else {
                    zerosInRows[i]++;
                    zerosInCols[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = onesInRows[i] + onesInCols[j] - zerosInRows[i] - zerosInCols[j];
            }
        }
        return grid;
    }
}
