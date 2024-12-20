package LeetCode.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem3375 {
    //https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/solutions/6167324/java-heap-solution-by-tbekpro-0eyj/

    //5min
    //Runtime
    //5
    //ms
    //Beats
    //22.35%
    //Analyze Complexity
    //Memory
    //44.34
    //MB
    //Beats
    //91.44%
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = 100, prev = -1;
        for (int n: nums) {
            if (set.contains(n)) continue;
            set.add(n);
            pq.offer(n);
            min = Math.min(min, n);
            if (min < k)
                return -1;
        }
        int res = 0;
        while (pq.size() > 0) {
            int largest = pq.poll();
            if (largest != k) res++;
        }
        return res;
    }
}
