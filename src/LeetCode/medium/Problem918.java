package LeetCode.medium;

public class Problem918 {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/description/
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{6,9,-3}));
        System.out.println(maxSubarraySumCircular(new int[]{-5, 4, -6}));
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
        System.out.println(maxSubarraySumCircular(new int[]{-2,4,-5,4,-5,9,4}));
    }

    //Runtime
    //6 ms
    //Beats
    //54.32%
    //Memory
    //47.9 MB
    //Beats
    //57.69%
    static int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);
            total += n;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    static int maxSubarraySumCircular2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        //find cumulative sum
        boolean hasPositive = nums[0] >= 0;
        int minSum = sumArr[0], minSumIdx = 0, initMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
            if (minSum > sumArr[i]) {
                minSum = sumArr[i];
                minSumIdx = i;
            }
            if (!hasPositive) hasPositive = nums[i] >= 0;
            if (initMax < sumArr[i]) initMax = sumArr[i];
        }
        //edge case
        if (!hasPositive) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i]) max = nums[i];
            }
            return max;
        }
        //rotate initial array so that minSum is the end
        int[] numsR = new int[nums.length];
        System.arraycopy(nums, minSumIdx + 1, numsR, 0, nums.length - minSumIdx - 1);
        System.arraycopy(nums, 0, numsR, nums.length - minSumIdx - 1, minSumIdx + 1);
        int max = numsR[0];
        for (int i = 1; i < numsR.length; i++) {
            if (max < numsR[i]) max = numsR[i];
            numsR[i] += numsR[i - 1];
            if (max < numsR[i]) max = numsR[i];
        }
        return Math.max(max, initMax);
    }

    static int maxSubarraySumCircular1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = nums[0], prevSum = sum, maxSum = sum;
        for (int i = 1; i < nums.length * 2; i++) {
            int n = nums[i % nums.length];
            prevSum = sum;
            sum += n;
            if (sum < prevSum || sum < n) sum = n;
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }
}
