package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2602 {
    //https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/
    public static void main(String[] args) {

    }

    //nnnnn
    //Runtime
    //51 ms
    //Beats
    //100%
    //Memory
    //59.9 MB
    //Beats
    //50%
    static List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        long[] runningSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) runningSum[i] = nums[i - 1] + runningSum[i - 1];
        List<Long> list = new ArrayList<>();
        for (int q : queries) {
            int idx = Arrays.binarySearch(nums, q);
            if (idx < 0) idx = -idx - 1;
            list.add(1L * q * (2 * idx - nums.length) + runningSum[nums.length] - (2 * runningSum[idx]));
        }
        return list;
    }

    //TLE 24/31
    static List<Long> minOperations1(int[] nums, int[] queries) {
        long sum = 0L;
        for (int n : nums) sum += n;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            long res = Math.abs(sum - ((long) nums.length * queries[i]));
            if (res < queries[i]) res *= queries[i];
            list.add(res);
        }
        return list;
    }
}
