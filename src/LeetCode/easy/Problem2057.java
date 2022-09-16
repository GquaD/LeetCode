package LeetCode.easy;

public class Problem2057 {
    //https://leetcode.com/problems/smallest-index-with-equal-value/
    public static void main(String[] args) {

    }

    //Runtime: 2 ms, faster than 38.65% of Java online submissions for Smallest Index With Equal Value.
    //Memory Usage: 46.4 MB, less than 59.63% of Java online submissions for Smallest Index With Equal Value.
    static int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
