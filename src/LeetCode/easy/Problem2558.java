package LeetCode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2558 {
    //https://leetcode.com/problems/take-gifts-from-the-richest-pile/
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25,64,9,4,100}, 4));
    }

    //https://leetcode.com/problems/take-gifts-from-the-richest-pile/solutions/3418221/java-using-priorityqueue/
    //10 min
    //Runtime
    //7 ms
    //Beats
    //65.59%
    //Memory
    //42.2 MB
    //Beats
    //50.26%
    static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : gifts) pq.offer(n);
        int count = 0;
        while (count++ < k) pq.offer((int) Math.sqrt(pq.poll()));
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}
