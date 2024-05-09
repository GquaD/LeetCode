package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem3075 {
    //https://leetcode.com/problems/maximize-happiness-of-selected-children
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximize-happiness-of-selected-children/solutions/5134860/java-o-nlogn-solution/
    //5-10min
    //Runtime
    //34
    //ms
    //Beats
    //97.44%
    //of users with Java
    //Memory
    //61.11
    //MB
    //Beats
    //94.10%
    //of users with Java

    static long maximumHappinessSum1(int[] happiness, int k) {
        long sum = 0;
        int count = 0;
        Arrays.sort(happiness);
        for (int i = happiness.length - 1; i >= 0; i--) {
            if (k <= 0) break;
            sum += Math.max(0, happiness[i] - count++);
            k--;
        }
        return sum;
    }


    //Runtime
    //186
    //ms
    //Beats
    //5.13%
    //of users with Java
    //Memory
    //76.39
    //MB
    //Beats
    //5.49%
    //of users with Java
    static long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : happiness) {
            pq.offer(n);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty()) {
            sum += Math.max(0, pq.poll() - --k);
        }
        return sum;
    }
}
