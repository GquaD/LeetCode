package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2874 {
    //https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println(maximumTripletValue(new int[]{1,10,3,4,19}));
        System.out.println(maximumTripletValue(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/solutions/4149859/java-5-to-100-faster-from-o-nlogn-to-o-n/
    //10 min both solutions
    //Runtime
    //2 ms
    //Beats
    //99.63%
    //Memory
    //58.2 MB
    //Beats
    //17.93%
    static long maximumTripletValue(int[] nums) {
        int[] diff = new int[nums.length];
        int tempMax = nums[0];
        for (int i = 1; i < diff.length - 1; i++) {
            diff[i] = tempMax - nums[i];
            tempMax = Math.max(tempMax, nums[i]);
        }
        long max = Long.MIN_VALUE;
        tempMax = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            max = Math.max(max, (long) tempMax * diff[i]);
            tempMax = Math.max(tempMax, nums[i]);
        }
        return Math.max(max, 0);
    }

    //
    //10min
    //Runtime
    //48 ms
    //Beats
    //5.30%
    //Memory
    //57.9 MB
    //Beats
    //24.66%
    static long maximumTripletValue1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] diff = new int[nums.length];
        pq.offer(nums[0]);
        for (int i = 1; i < diff.length - 1; i++) {
            diff[i] = pq.peek() - nums[i];
            pq.offer(nums[i]);
        }
        long max = Long.MIN_VALUE;
        pq.clear();
        pq.offer(nums[nums.length - 1]);
        for (int i = nums.length - 2; i > 0; i--) {
            max = Math.max(max, (long) pq.peek() * diff[i]);
            pq.offer(nums[i]);
        }
        return Math.max(max, 0);
    }
}
