package LeetCode.medium;

import java.util.Arrays;

public class Problem3867 {
    //5min

    //Runtime
    //56
    //ms
    //Beats
    //67.00%
    //Memory
    //122.16
    //MB
    //Beats
    //42.00%
    //https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/solutions/8402038/java-fast-solution-by-tbekpro-m8hu/
    public long gcdSum(int[] nums) {
        int max = 0;
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            nums[i] = gcd(max, nums[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            sum += gcd(nums[i], nums[nums.length - i - 1]);
        }

        return sum;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
