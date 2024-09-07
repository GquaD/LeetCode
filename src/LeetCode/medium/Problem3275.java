package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem3275 {
    //https://leetcode.com/problems/k-th-nearest-obstacle-queries
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/k-th-nearest-obstacle-queries/solutions/5750506/java-o-nlogk-solution/
    //5-10min
    //Runtime
    //89
    //ms
    //Beats
    //88.42%
    //Analyze Complexity
    //Memory
    //168.47
    //MB
    //Beats
    //35.17%
    static int[] resultsArray(int[][] queries, int k) {
        int[] arr = new int[queries.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < queries.length; i++) {
            int dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.offer(dist);
            if (pq.size() > k) pq.poll();
            arr[i] = pq.size() < k ? -1 : pq.peek();
        }
        return arr;
    }
}
