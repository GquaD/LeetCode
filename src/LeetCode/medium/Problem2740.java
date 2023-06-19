package LeetCode.medium;

import java.util.Arrays;

public class Problem2740 {
    //https://leetcode.com/problems/find-the-value-of-the-partition/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-value-of-the-partition/solutions/3657514/java-o-nlogn-4-lines-100-faster-sort-find-min-difference/
    //5min
    //Runtime
    //22 ms
    //Beats
    //100%
    //Memory
    //55 MB
    //Beats
    //33.33%
    static int findValueOfPartition1(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) min = Math.min(nums[i] - nums[i - 1], min);
        return min;
    }
}
