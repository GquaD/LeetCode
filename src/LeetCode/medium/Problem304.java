package LeetCode.medium;

public class Problem304 {
    //https://leetcode.com/problems/range-sum-query-2d-immutable/
    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(matrix.sumRegion(0,1,0,3));
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));

        NumMatrix mat = new NumMatrix(new int[][]{{-4,-5}});
        System.out.println(mat.sumRegion(0,0,0,0));
        System.out.println(mat.sumRegion(0,0,0,1));
        System.out.println(mat.sumRegion(0,1,0,1));
    }
}
//need 2 matrices
//1st will have horizontal running sum for each row
//2nd will have vertical running sum for each column


//https://leetcode.com/problems/range-sum-query-2d-immutable/solutions/3569522/java-o-1-solution-100-less-memory/
//30-40min
//Runtime
//137 ms
//Beats
//37.66%
//Memory
//57.1 MB
//Beats
//99.83%
class NumMatrix {

    int[][] matH;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        matH = matrix;
        for (int r = 0; r < m; r++) for (int c = 0; c < n; c++) matH[r][c] = c == 0 ? matrix[r][c] : matrix[r][c] + matH[r][c - 1];
        for (int c = 0; c < n; c++) for (int r = 0; r < m; r++) matH[r][c] = r == 0 ? matH[r][c] : matH[r][c] + matH[r - 1][c];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int upRect = row1 == 0 ? 0 : matH[row1 - 1][col2], leftRect = col1 == 0 ? 0 : matH[row2][col1 - 1] - (row1 == 0 ? 0 : matH[row1 - 1][col1 - 1]);
        return matH[row2][col2] - upRect - leftRect;
    }
}
