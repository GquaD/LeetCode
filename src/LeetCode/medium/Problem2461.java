package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2461 {
    //https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/solutions/6061877/java-o-n-one-pass-solution/
    //10-15min
    //Runtime
    //45
    //ms
    //Beats
    //52.96%
    //Analyze Complexity
    //Memory
    //57.28
    //MB
    //Beats
    //79.45%
    //Analyze Complexity
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i >= k - 1) {
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= nums[i - k + 1];
                int freq = map.get(nums[i - k + 1]);
                if (freq > 1) map.put(nums[i - k + 1], freq - 1);
                else map.remove(nums[i - k + 1]);
            }
        }
        return maxSum;
    }
}
