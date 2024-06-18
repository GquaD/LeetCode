package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem826 {
    //https://leetcode.com/problems/most-profit-assigning-work/?envType=daily-question&envId=2024-06-18
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-profit-assigning-work/solutions/5332700/java-using-2-heaps/
    //20min
    //Runtime
    //45
    //ms
    //Beats
    //27.52%
    //Analyze Complexity
    //Memory
    //45.79
    //MB
    //Beats
    //39.31%
    int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit == a.profit ? b.diff - a.diff : b.profit - a.profit);
        PriorityQueue<Integer> pqw = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profit.length; i++) {
            pq.offer(new Pair(difficulty[i], profit[i]));
        }

        for (int w : worker) pqw.offer(w);

        int score = 0;
        while (!pq.isEmpty() && !pqw.isEmpty()) {
            int w = pqw.peek();
            Pair p = pq.peek();

            if (w >= p.diff) {
                pqw.poll();
                score += p.profit;
            } else {
                pq.poll();
            }
        }
        return score;
    }
}

class Pair {
    int diff, profit;

    public Pair(int diff, int profit) {
        this.diff = diff;
        this.profit = profit;
    }
}