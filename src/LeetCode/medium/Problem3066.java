package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem3066 {
    //https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/solutions/6417683/java-heap-solution-by-tbekpro-fful/
    //5min
    //Runtime
    //149
    //ms
    //Beats
    //62.14%
    //Analyze Complexity
    //Memory
    //70.57
    //MB
    //Beats
    //69.96%
    public int minOperations(int[] nums, int k) {
        if (nums.length < 2) return 0;
        int res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int n: nums) pq.offer((long)n);
        while (pq.size() > 1 && pq.peek() < k) {
            long min = pq.poll(), next = pq.poll();
            pq.offer(min * 2 + next);
            res++;
        }
        return res;
    }
}
