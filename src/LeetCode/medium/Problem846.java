package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem846 {
    //https://leetcode.com/problems/hand-of-straights/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/hand-of-straights/solutions/5268841/java-o-nlogn-using-priorityqueue/
    //10-15min
    //Runtime
    //23
    //ms
    //Beats
    //94.91%
    //of users with Java
    //Memory
    //45.66
    //MB
    //Beats
    //34.63%
    //of users with Java
    static boolean isNStraightHand(int[] hand, int g) {
        int len = hand.length;
        if (len % g != 0) return false;
        if (g == 1) return true;
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pq1 = new PriorityQueue<>();
        for (int n : hand)
            pq.offer(n);

        int prev = pq.poll();
        int count = g - 1;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == prev) {
                pq1.offer(cur);
            } else if (cur - prev == 1) {
                prev = cur;
                count--;
            } else {
                return false;
            }
            if (!(pq.isEmpty() && pq1.isEmpty())) {
                if (count == 0) {
                    pq.addAll(pq1);
                    pq1.clear();
                    if (pq.isEmpty()) break;
                    prev = pq.poll();
                    count = g - 1;
                }
            }
        }
        return count == 0;
    }
}
