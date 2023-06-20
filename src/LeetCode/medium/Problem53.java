package LeetCode.medium;

public class Problem53 {
    //https://leetcode.com/problems/maximum-subarray/
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }

    //
    //5 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //60.1 MB
    //Beats
    //5.45%
    static int maxSubArray(int[] nums) {
        int sumTemp = 0, sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sumTemp = Math.max(sumTemp + nums[i], nums[i]);
            sumMax = Math.max(sumMax, sumTemp);
        }
        return sumMax;
    }

    static int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int idxMax = -1, idxMin = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        if (max < 0 && min < 0) {
            return min - max;
        } else if (min < 0 && max > 0) {
            return max - min;
        } else {
            return max;
        }

    }
}
