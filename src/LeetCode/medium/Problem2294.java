package LeetCode.medium;

import java.util.Arrays;

public class Problem2294 {
    //https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3,6,1,2,5}, 2));
        System.out.println(partitionArray(new int[]{1,2,3}, 1));
        System.out.println(partitionArray(new int[]{2,2,4,5}, 0));
    }

    //10-13 mins
    //Runtime: 64 ms, faster than 10.51% of Java online submissions for Partition Array Such That Maximum Difference Is K.
    //Memory Usage: 75.9 MB, less than 83.16% of Java online submissions for Partition Array Such That Maximum Difference Is K.
    static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                count++;
                start = nums[i];
            }
        }
        return count;
    }
}
