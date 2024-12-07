package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1760 {
    //https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{9}, 2));
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
    }

    //1-2h
    //nnn
    //Runtime
    //26
    //ms
    //Beats
    //93.10%
    //Analyze Complexity
    //Memory
    //60.38
    //MB
    //Beats
    //25.91%
    static int minimumSize(int[] nums, int ops) {
        int min = 1, max = 1_000_000_000;
        while (min < max) {
            int mid = (min + max) / 2, counter = 0;
            for (int n : nums)
                counter += (n - 1) / mid;
            if (counter <= ops)
                max = mid;
            else
                min = mid + 1;
        }
        return min;
    }

//    static int minimumSize(int[] nums, int maxOperations) {
//        return 1;
//    }
//
//    static int minimumSize1(int[] nums, int maxOperations) {
//        if (nums.length == 1)
//            return nums[0] % (maxOperations + 1) > 0 ? (nums[0] / (maxOperations + 1)) + 1 : nums[0] / (maxOperations + 1);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int n : nums) pq.offer(n);
//        while (maxOperations > 0) {
//            if (pq.peek() == 1) break;
//            int last = pq.poll();
//            pq.offer(last / 2);
//            if (last % 2 == 0) pq.offer(last / 2);
//            else pq.offer(last / 2 + 1);
//            maxOperations--;
//        }
//        return pq.peek();
//    }
}
