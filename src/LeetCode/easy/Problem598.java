package LeetCode.easy;

public class Problem598 {
    //https://leetcode.com/problems/range-addition-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/range-addition-ii/solutions/3227332/java-6-lines-100-faster-solution/
    //10min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43 MB
    //Beats
    //17.72%
    static int maxCount(int m, int n, int[][] ops) {
        int minX = 40_001, minY = minX;
        for (int[] op : ops) {
            minX = Math.min(op[0] + 1, minX);
            minY = Math.min(op[1] + 1, minY);
        }
        return ops.length == 0 ? m * n : minY * minX;
    }


    //fails on 7/69
    static int maxCount1(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int[][] arr = new int[m][n];
        int max = 0, count = 0;
        for (int[] op : ops) for (int x = 0; x < op[0]; x++) for (int y = 0; y < op[1]; y++) max = Math.max(++arr[x][y], max);
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (arr[i][j] == max) count++;
        return count;
    }
}
