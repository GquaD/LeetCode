package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1578 {
    //https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
    public static void main(String[] args) {
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5}));
    }

    //https://leetcode.com/problems/minimum-time-to-make-rope-colorful/solutions/3630476/java-greedy-using-priorityqueue/
    //15 min
    //Runtime
    //156 ms
    //Beats
    //5.10%
    //Memory
    //56.6 MB
    //Beats
    //53.69%
    static int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(neededTime[0]);
        int count = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                while (pq.size() > 1) count += pq.poll();
                pq.clear();
            }
            pq.offer(neededTime[i]);
        }
        while (pq.size() > 1) count += pq.poll();
        return count;
    }
}
