package LeetCode.hard;

import java.util.*;

public class Problem2009 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 98, 97, 1000}));
        System.out.println(minOperations(new int[]{4,2,5,3}));
        System.out.println(minOperations(new int[]{1,2,3,5,6}));
        System.out.println(minOperations(new int[]{1,10,100,1000}));
        System.out.println(minOperations(new int[]{1,99,98,100}));

    }

    //nnnn
    //Runtime
    //144 ms
    //Beats
    //13.73%
    //Memory
    //58.1 MB
    //Beats
    //35.29%
    static int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int n = nums.length, ops = n, r = 0;
        Set<Integer> set = new TreeSet<>();
        for (int k : nums) set.add(k);
        Integer[] arr = set.toArray(new Integer[set.size()]);

        for (int l = 0; l < arr.length; l++) {
            while (r < arr.length && arr[r] < arr[l] + n) r++;
            ops = Math.min(ops, n - r + l);
        }
        return ops;
    }

    static int minOperations2(int[] nums) {
        if (nums.length == 1) return 0;
        int min = Integer.MAX_VALUE, max = 0, n = nums.length, temp = min;
        long sum = 0, sumDiff = Long.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            long sumCurr = ((long) (nums[i] + nums[i] + nums.length - 1) * nums.length) / 2;
            if (sumDiff > Math.abs(sum - sumCurr)) {
                sumDiff = Math.abs(sum - sumCurr);
                temp = nums[i];
            }
        }
        int count = 0;
        for (int i = temp; i < temp + n; i++) {
            if (!set.contains(i)) count++;
        }

        return count;
    }

    static int minOperations1(int[] nums) {
        if (nums.length == 1) return 0;
        long sum = nums[0];
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        long sumLeft = ((long) (min + min + nums.length - 1) * nums.length) / 2;
        long sumRight = ((long) (max + max - nums.length + 1) * nums.length) / 2;
        return 42;
    }
}
