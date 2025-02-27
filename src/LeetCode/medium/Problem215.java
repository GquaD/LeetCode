package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem215 {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,1,2,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,1,2,5,5,6,4}, 3));
    }

    //1min
    //Runtime
    //62
    //ms
    //Beats
    //42.53%
    //Analyze Complexity
    //Memory
    //62.01
    //MB
    //Beats
    //7.31%
    //public int findKthLargest(int[] nums, int k) {
    //        PriorityQueue<Integer> pq = new PriorityQueue<>();
    //        for (int n: nums) {
    //            pq.offer(n);
    //            if (pq.size() > k) pq.poll();
    //        }
    //        return pq.poll();
    //    }

    //Solution complexity is O(NlogN), however description requires O(N)
    //that's why not posting this
    //2 min
    //Runtime
    //25 ms
    //Beats
    //73.42%
    //Memory
    //49.7 MB
    //Beats
    //91.49%
    static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int max = -10_001;
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                pq.offer(max);
            }
        }
        return 1;
    }
}
