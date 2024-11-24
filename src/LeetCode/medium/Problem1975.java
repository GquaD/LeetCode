package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1975 {
    //https://leetcode.com/problems/maximum-matrix-sum
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-matrix-sum/solutions/6079351/java-messy-solution/
    //15-20min
    //Runtime
    //61
    //ms
    //Beats
    //29.87%
    //Analyze Complexity
    //Memory
    //55.42
    //MB
    //Beats
    //8.86%
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length, count0 = 0;
        int min = 100_000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix[i][j];
                if (a == 0) count0++;
                if (a < 0) {
                    pq.offer(a);
                } else {
                    sum += a;
                }
                min = Math.min(min, Math.abs(a));
            }
        }
        int size = pq.size();
        if (count0 == 0) {
            size = size % 2 == 1 ? size - 1 : size;
        }
        while (size > 0) {
            sum -= pq.poll();
            size--;
        }
        if (pq.size() > 0) {
            int last = pq.poll();
            if (Math.abs(last) >= min) {
                sum -= min * 2;
                sum -= last;
            } else {
                sum -= last;
            }
        }
        return sum;
    }
}
