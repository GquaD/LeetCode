package LeetCode.medium;

import java.util.Arrays;

public class Problem3189 {
    //https://leetcode.com/problems/minimum-moves-to-get-a-peaceful-board/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-moves-to-get-a-peaceful-board/solutions/5621915/java-using-sorting/
    //nnn
    //Runtime
    //14
    //ms
    //Beats
    //69.15%
    //Analyze Complexity
    //Memory
    //44.86
    //MB
    //Beats
    //63.83%
    public int minMoves(int[][] rooks) {
        int n = rooks.length, sum = 0;
        Arrays.sort(rooks, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            sum += Math.abs(i - rooks[i][0]);
        }
        Arrays.sort(rooks, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            sum += Math.abs(i - rooks[i][1]);
        }
        return sum;
    }
}
