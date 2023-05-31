package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem2536 {
    //https://leetcode.com/problems/increment-submatrices-by-one/description/

    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(rangeAddQueries(3, new int[][]{{1,1,2,2}, {0,0,1,1}}));
    }

    //https://leetcode.com/problems/increment-submatrices-by-one/solutions/3583266/java-3-line-brute-force-solution/
    //3 min
    //Runtime
    //514 ms
    //Beats
    //27.85%
    //Memory
    //55.9 MB
    //Beats
    //8.86%
    static int[][] rangeAddQueries1(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            for (int r = r1; r <= r2; r++) for (int c = c1; c <= c2; c++) res[r][c]++;
        }
        return res;
    }

    //Runtime
    //637 ms
    //Beats
    //9.49%
    //Memory
    //55.9 MB
    //Beats
    //8.86%
    static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] q : queries)
            for (int r = q[0]; r <= q[2]; r++)
                for (int c = q[1]; c <= q[3]; c++)
                    res[r][c]++;
        return res;
    }
}
