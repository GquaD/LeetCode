package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2542 {
    //https://leetcode.com/problems/maximum-subsequence-score/
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }

    //wrong
    static long maxScore(int[] nums1, int[] nums2, int k) {
        if (k == 1) {
            long max = 0;
            for (int i = 0; i < nums1.length; i++) max = Math.max(max, 1L * nums1[i] * nums2[i]);
            return max;
        }
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]), pq2 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < nums1.length; i++) {
            pq1.offer(new int[]{nums1[i], i});
            pq2.offer(new int[]{nums2[i], i});
        }
        long sum1 = 0, sum2 = 0;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        for (int i = 0; i < k; i++) {
            int[] t1 = pq1.poll(), t2 = pq2.poll();
            sum1 += t1[0];
            min1 = Math.min(min1, nums2[t1[1]]);

            sum2 += nums1[t2[1]];
            min2 = Math.min(min2, t2[0]);
        }
        return Math.max(sum1 * min1, sum2 * min2);
    }

    static long maxScore1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]), pq2 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < nums1.length; i++) {
            pq1.offer(new int[]{nums1[i], i});
            pq2.offer(new int[]{nums2[i], i});
        }
        int[] one = pq1.poll(), two = pq1.poll(), three = pq1.poll();
        long res1 = (one[0] + two[0] + three[0]) * Math.min(nums2[one[1]], Math.min(nums2[two[1]], nums2[three[1]]));

        int[] four = pq2.poll(), five = pq2.poll(), six = pq2.poll();
        long res2 = (four[0] + five[0] + six[0]) * Math.min(nums1[four[1]], Math.min(nums1[five[1]], nums1[six[1]]));
        return Math.max(res1, res2);
    }


}
