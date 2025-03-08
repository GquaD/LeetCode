package LeetCode.medium;

import java.util.*;

public class Problem3476 {
    //https://leetcode.com/problems/maximize-profit-from-task-assignment
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximize-profit-from-task-assignment/solutions/6514513/java-onlogn-solution-by-tbekpro-wv2e/
    //15min
    //Runtime
    //57
    //ms
    //Beats
    //87.50%
    //Analyze Complexity
    //Memory
    //99.00
    //MB
    //Beats
    //34.38%
    public long maxProfit(int[] workers, int[][] tasks) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        map.put(-1, new PriorityQueue<>((a, b) -> b - a));
        for (int n: workers) map.put(n, new PriorityQueue<>((a, b) -> b - a));
        for (int[] task: tasks) {
            PriorityQueue<Integer> pq = map.get(task[0]);
            if (pq != null) pq.offer(task[1]);
            else map.get(-1).offer(task[1]);
        }

        long sum = 0;
        for (int n: workers) {
            PriorityQueue<Integer> pq = map.get(n);
            if (pq != null && pq.size() > 0) sum += pq.poll();
        }
        int max = 0;
        for (int k: map.keySet()) {
            PriorityQueue<Integer> pq = map.get(k);
            if (pq.size() > 0) max = Math.max(max, pq.peek());
        }
        return sum + max;
    }
}
