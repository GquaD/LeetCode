package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2530 {
    //https://leetcode.com/problems/maximal-score-after-applying-k-operations/
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    //https://leetcode.com/problems/maximal-score-after-applying-k-operations/solutions/4239059/java-priorityqueue-o-nlogn/
    //5min
    //Runtime
    //146 ms
    //Beats
    //26.74%
    //Memory
    //60 MB
    //Beats
    //47.9%
    static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) pq.offer(n);
        long score = 0L;
        for (int i = 0; i < k; i++) {
            int t = pq.poll();
            score += t;
            pq.offer((int) Math.ceil(t / 3.0));
        }
        return score;
    }
}
