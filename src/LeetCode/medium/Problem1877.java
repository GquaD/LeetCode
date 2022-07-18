package LeetCode.medium;

import java.util.Arrays;

public class Problem1877 {
    //https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
        System.out.println(minPairSum(new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4}));
        System.out.println("///////////////////////");
        System.out.println(minPairSum1(new int[]{3, 5, 2, 3}));
        System.out.println(minPairSum1(new int[]{3, 5, 4, 2, 4, 6}));
        System.out.println(minPairSum1(new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4}));
        System.out.println("///////////////////////");
        System.out.println(minPairSum2(new int[]{3, 5, 2, 3}));
        System.out.println(minPairSum2(new int[]{3, 5, 4, 2, 4, 6}));
        System.out.println(minPairSum2(new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4}));
    }

    //Runtime: 84 ms, faster than 20.46% of Java online submissions for Minimize Maximum Pair Sum in Array.
    //Memory Usage: 105.1 MB, less than 77.67% of Java online submissions for Minimize Maximum Pair Sum in Array.
    static int minPairSum2(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int sum = nums[i] + nums[nums.length - 1 - i];
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    //incorrect
    static int minPairSum1(int[] nums) {
        if (nums.length >= 4) {
            if ((nums[0] == nums[1] && nums[nums.length - 1] != nums[nums.length - 2])
                    || (nums[0] != nums[1] && nums[nums.length - 1] == nums[nums.length - 2])) {
                return minPairSum(nums);
            }
        }
        Arrays.sort(nums);
        return nums[nums.length / 2 - 1] + nums[nums.length / 2];

    }
    //incorrect
    static int minPairSum(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return max + min;
    }
}
