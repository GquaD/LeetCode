package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem983 {
    //https://leetcode.com/problems/minimum-cost-for-tickets/description/
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }

    //nnnn
    //Runtime
    //3 ms
    //Beats
    //21.1%
    //Memory
    //42 MB
    //Beats
    //18.2%
    static int mincostTickets(int[] days, int[] costs) {
        Queue<int[]> last7 = new LinkedList<>(), last30 = new LinkedList<>();
        int cost = 0;
        for (int d : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= d) last7.poll();
            while (!last30.isEmpty() && last30.peek()[0] + 30 <= d) last30.poll();
            last7.offer(new int[]{d, cost + costs[1]});
            last30.offer(new int[]{d, cost + costs[2]});
            cost = Math.min(cost + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }
        return cost;
    }
}
