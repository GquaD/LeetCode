package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1738 {
    //https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}, 2));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
    }

    //https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/solutions/4581769/java-o-nlogk-priorityqueue/
    //30-40min
    //Runtime
    //250
    //ms
    //Beats
    //22.22%
    //of users with Java
    //Memory
    //198.63
    //MB
    //Beats
    //12.70%
    //of users with Java
    static int kthLargestValue(int[][] m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int a = m.length, b = m[0].length;

        for (int i = 0; i < a; i++) {
            for (int j = 1; j < b; j++) {
                m[i][j] ^= m[i][j - 1];
            }
        }
        for (int i = 0; i < b; i++) {
            pq.offer(m[0][i]);
            if (pq.size() > k) pq.poll();
        }
        for (int j = 0; j < b; j++) {
            for (int i = 1; i < a; i++) {
                m[i][j] ^= m[i - 1][j];
                pq.offer(m[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
    }
}
