package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem3080 {
    //https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(unmarkedSumArray(new int[]{18,5,5,5,5,18,13,5,10,13,18,13,19,14,14,13,14,13,11},
                new int[][]{{6,0},{14,1},{13,3},{7,2},{5,2},{8,1},{5,3},{9,0},{4,2},{4,4},{9,2},{15,0},{1,3},{13,1},{11,0},{16,4},{3,2},{17,3},{11,1}})));
    }

    //https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/solutions/5012200/java-priorityqueue-of-pairs/
    //20-25min
    //Runtime
    //137
    //ms
    //Beats
    //44.92%
    //of users with Java
    //Memory
    //74.31
    //MB
    //Beats
    //33.78%
    //of users with Java
    static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum += n;
            pq.offer(new int[]{n, i});
        }

        long[] res = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int idx = q[0], k = q[1];

            if (nums[idx] != 0) {
                sum -= nums[idx];
                nums[idx] = 0;
            }

            while (k > 0 && pq.size() > 0) {
                int[] arr = pq.poll();
                int val = arr[0], idx1 = arr[1];
                if (nums[idx1] != 0) {
                    k--;
                    sum -= val;
                    nums[idx1] = 0;
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
