package LeetCode.medium;

import java.util.*;

public class Problem2841 {
    //https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/
    public static void main(String[] args) {
        System.out.println(maxSum(Arrays.asList(1), 1, 1));
    }

    //https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/solutions/4001338/java-sliding-window-map/
    //20 min
    //Runtime
    //18 ms
    //Beats
    //33.33%
    //Memory
    //45.1 MB
    //Beats
    //33.33%
    static long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0, tempSum = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            tempSum += nums.get(i);
        }
        int idx = 0;
        if (map.size() >= m) sum = Math.max(sum, tempSum);
        for (int i = k; i < nums.size(); i++) {
            int freq = map.get(nums.get(idx));
            if (freq == 1) map.remove(nums.get(idx));
            else if (freq > 1) map.put(nums.get(idx), map.get(nums.get(idx)) - 1);
            tempSum -= nums.get(idx);
            tempSum += nums.get(i);
            idx++;
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if (map.size() >= m) sum = Math.max(sum, tempSum);
        }
        return sum;
    }
}
