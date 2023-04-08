package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1043 {
    //https://leetcode.com/problems/partition-array-for-maximum-sum/
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }

    //nnnn
    //Runtime
    //5 ms
    //Beats
    //97.56%
    //Memory
    //42.1 MB
    //Beats
    //43.99%
    static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            int currMax = 0, best = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                best = Math.max(best, dp[i - j] + (currMax * j));
            }
            dp[i] = best;
        }
        return dp[arr.length];
    }

    static int maxSumAfterPartitioning1(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getVal).thenComparing(Pair::getIdx).reversed());
        for (int i = 0; i < arr.length; i++) pq.offer(new Pair(arr[i], i));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int tempK = k;
            if (arr.length - p.idx < k / 2) {
                for (int i = p.idx + 1; i < arr.length; i++) {
                    arr[i] = p.val;
                }
                for (int i = p.idx - (k - arr.length + p.idx); i < p.idx; i++) {
                    arr[i] = p.val;
                }
            } else {
                int left = p.idx - 1, right = p.idx + 1;
                tempK--;
                while (tempK > 0) {
                    arr[left] = p.val;
                    tempK--;
                    if (tempK == 0) break;
                    arr[right] = p.val;
                    tempK --;
                }
            }
        }
        return 42;
    }

    static class Pair {
        int val, idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public int getIdx() {
            return idx;
        }
    }
}
