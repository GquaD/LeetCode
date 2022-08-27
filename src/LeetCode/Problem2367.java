package LeetCode;

public class Problem2367 {
    //https://leetcode.com/problems/number-of-arithmetic-triplets/
    public static void main(String[] args) {

    }

    //Runtime: 62 ms, faster than 5.03% of Java online submissions for Number of Arithmetic Triplets.
    //Memory Usage: 42.3 MB, less than 39.07% of Java online submissions for Number of Arithmetic Triplets.
    static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
