package LeetCode.easy;

public class Problem1582 {
    //https://leetcode.com/problems/special-positions-in-a-binary-matrix/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/special-positions-in-a-binary-matrix/solutions/2780580/java-solution-91-time-95-memory/
    //Runtime
    //2 ms
    //Beats
    //90.68%
    //Memory
    //42.4 MB
    //Beats
    //94.7%
    static int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && isSpecialRow(i, mat) && isSpecialCol(j, mat)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSpecialRow(int row, int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat[row].length; i++) {
            sum += mat[row][i];
            if (sum > 1) return false;
        }
        return true;
    }

    private static boolean isSpecialCol(int col, int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][col];
            if (sum > 1) return false;
        }
        return true;
    }
}
