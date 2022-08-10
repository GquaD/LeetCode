package LeetCode.medium;

public class Problem2221 {
    //https://leetcode.com/problems/find-triangular-sum-of-an-array/
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5}));
        System.out.println(triangularSum(new int[]{5}));
    }
    //done in 10 mins
    //Runtime: 98 ms, faster than 71.99% of Java online submissions for Find Triangular Sum of an Array.
    //Memory Usage: 48.7 MB, less than 50.00% of Java online submissions for Find Triangular Sum of an Array.
    static int triangularSum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
