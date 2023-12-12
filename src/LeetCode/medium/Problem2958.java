package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2958 {
    //https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 1, 1, 3}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 3, 1, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{2, 2, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 4, 4, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{2}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }

    //nnnn
    //Runtime
    //79 ms
    //Beats
    //15.31%
    //Memory
    //55.9 MB
    //Beats
    //97.2%
    static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer freq = map.get(n);
            if (freq == null) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
            while (map.get(n) > k) {
                int curr = nums[start];
                map.put(curr, map.get(curr) - 1);
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    //Wrong Answer
    //851 / 992 testcases passed
    static int maxSubarrayLength1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0, start = 0;
        for (int n : nums) {
            Integer freq = map.get(n);
            if (freq == null) {
                map.put(n, 1);
                count++;
            } else if (freq < k) {
                map.put(n, map.get(n) + 1);
                count++;
            } else {
                /*while (start < nums.length && nums[start] != n) {
                    map.put(nums[start], map.get(nums[start]) - 1);
                    count--;
                    start++;
                }*/
                count = map.size() == 1 ? map.size() * k : map.size() * k - 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
