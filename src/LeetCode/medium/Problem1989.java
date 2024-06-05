package LeetCode.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem1989 {
    //https://leetcode.com/problems/maximum-number-of-people-that-can-be-caught-in-tag/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-number-of-people-that-can-be-caught-in-tag/solutions/5263303/java-using-2-queues/
    //10min
    //Runtime
    //15
    //ms
    //Beats
    //18.18%
    //of users with Java
    //Memory
    //64.26
    //MB
    //Beats
    //9.09%
    //of users with Java
    static int catchMaximumAmountofPeople(int[] team, int dist) {
        Queue<Integer> pq0 = new LinkedList<>();
        Queue<Integer> pq1 = new LinkedList<>();
        for (int i = 0; i < team.length; i++) {
            if (team[i] == 0) {
                pq0.offer(i);
            } else {
                pq1.offer(i);
            }
        }
        if (pq0.isEmpty() || pq1.isEmpty()) return 0;
        int res = 0;
        while (!pq1.isEmpty()) {
            if (pq0.isEmpty()) break;
            int idx1 = pq1.peek(), idx0 = pq0.peek();
            if (Math.abs(idx1 - idx0) <= dist) {
                res++;
                pq1.poll();
                pq0.poll();
            } else {
                if (idx1 < idx0) {
                    pq1.poll();
                } else {
                    pq0.poll();
                }
            }
        }
        return res;
    }
}
