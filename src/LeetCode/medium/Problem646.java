package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem646 {
    //https://leetcode.com/problems/maximum-length-of-pair-chain/
    public static void main(String[] args) {

    }

    //
    //15 min
    //Runtime
    //10 ms
    //Beats
    //97.56%
    //Memory
    //44.5 MB
    //Beats
    //6.48%
    static int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] arr : pairs) pq.offer(arr);
        int count = 1, temp[] = pq.poll();
        while (!pq.isEmpty()) {
            int[] sec = pq.poll();
            if (temp[1] < sec[0]) {
                temp = sec;
                count++;
            }
        }
        return count;
    }
}
