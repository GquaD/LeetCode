package LeetCode;

public class Problem2006 {
    //https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
    public static void main(String[] args) {

    }
    //Runtime: 8 ms, faster than 67.28% of Java online submissions for Count Number of Pairs With Absolute Difference K.
    //Memory Usage: 42.1 MB, less than 85.22% of Java online submissions for Count Number of Pairs With Absolute Difference K.
    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
