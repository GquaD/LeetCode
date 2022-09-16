package LeetCode;

public class Problem1827 {
    //https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,5,2,4,1}));
    }

    //Runtime: 3 ms, faster than 82.13% of Java online submissions for Minimum Operations to Make the Array Increasing.
    //Memory Usage: 48.8 MB, less than 69.80% of Java online submissions for Minimum Operations to Make the Array Increasing.
    static int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                prev = nums[i];
            } else {
                prev++;
                count += prev - nums[i];
            }
        }
        return count;
    }
}
