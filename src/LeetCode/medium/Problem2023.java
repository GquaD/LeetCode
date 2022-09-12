package LeetCode.medium;

public class Problem2023 {
    //https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
    public static void main(String[] args) {

    }
    //10 mins in editor in browser
    //Runtime: 78 ms, faster than 11.75% of Java online submissions for Number of Pairs of Strings With Concatenation Equal to Target.
    //Memory Usage: 62.4 MB, less than 16.60% of Java online submissions for Number of Pairs of Strings With Concatenation Equal to Target.
    static int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]).equals(target) && i != j) {
                    count++;
                }
            }
        }
        return count;
    }
}
