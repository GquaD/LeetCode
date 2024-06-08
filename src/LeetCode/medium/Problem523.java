package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {
    //https://leetcode.com/problems/continuous-subarray-sum/

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
        System.out.println(checkSubarraySum(new int[]{0, 0}, 1));
    }

    static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (i > 0 && sum == 0 || map.containsKey(sum) && i - map.get(sum) > 1) return true;
            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return false;
    }

    static boolean checkSubarraySum4(int[] nums, int k) {
        return false;
    }


    //trying sliding window
    //time limit exceeded 94/97
    static boolean checkSubarraySum3(int[] nums, int k) {
        int sizeWindow = 2, sum = 0;
        while (sizeWindow <= nums.length) {
            for (int i = 0; i <= nums.length - sizeWindow; i++) {
                for (int j = i; j < i + sizeWindow; j++) {
                    sum += nums[j];
                }
                if (sum % k == 0 || sum == 0) return true;
                sum = 0;
            }
            sizeWindow++;
        }
        return false;
    }

    //time limit exceeded 94/97
    static boolean checkSubarraySum2(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i], tempIdx = i + 1;
            while (tempIdx < nums.length) {
                sum += nums[tempIdx++];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkSubarraySum1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= k;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = 0, tempIdx = i;
            while (tempIdx < nums.length) {
                sum += nums[tempIdx++];
                if (sum == k) {
                    return true;
                }
                if (sum > k) {
                    sum %= k;
                }
            }
        }
        return false;
    }
}
