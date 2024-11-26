package LeetCode.easy;

import java.util.Arrays;

public class Problem2996 {
    //https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/solutions/6085101/java-1ms-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //87.80%
    //Analyze Complexity
    //Memory
    //42.15
    //MB
    //Beats
    //55.45%
    public int missingInteger(int[] nums) {
        int sum = nums[0], sumMax = sum;
        boolean broken = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                sum += nums[i];
            } else {
                sumMax = Math.max(sum, sumMax);
                sum = nums[i];
                broken = true;
                break;
            }
        }
        if (!broken) sumMax = Math.max(sum, sumMax);

        Arrays.sort(nums);
        for (int n : nums) {
            if (n == sumMax)
                sumMax++;
        }
        return sumMax;
    }
}
