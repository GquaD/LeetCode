package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem3462 {
    //https://leetcode.com/problems/maximum-sum-with-at-most-k-elements
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/solutions/6481792/java-onlogk-solution-by-tbekpro-xmcu/
    //5min
    //Runtime
    //177
    //ms
    //Beats
    //50.68%
    //Analyze Complexity
    //Memory
    //70.68
    //MB
    //Beats
    //68.77%
    public long maxSum(int[][] grid, int[] limits, int k) {
        for (int[] arr: grid) Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= grid[i].length - limits[i]; j--) {
                pq.offer(grid[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        long result = 0;
        while (pq.size() > 0) result += pq.poll();
        return result;
    }
}
