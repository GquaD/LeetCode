package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1167 {
    //https://leetcode.com/problems/minimum-cost-to-connect-sticks
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/minimum-cost-to-connect-sticks/solutions/5823392/java-o-nlogn-solution/
    //5min
    //Runtime
    //64
    //ms
    //Beats
    //21.16%
    //Analyze Complexity
    //Memory
    //45.02
    //MB
    //Beats
    //48.82%
    static int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : sticks) pq.offer(n);
        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll(), sum = a + b;
            cost += sum;
            pq.offer(sum);
        }
        return cost;
    }
}
