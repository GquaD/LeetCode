package LeetCode;

import java.util.Arrays;

public class Problem2357 {
    //https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(minimumOperations(new int[]{0}));
    }

    //Runtime: 4 ms, faster than 25.84% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
    //Memory Usage: 41.6 MB, less than 81.21% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.

    //before comment
    //Runtime: 4 ms, faster than 25.84% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
    //Memory Usage: 41.7 MB, less than 67.39% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
    static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == 0) continue;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > 0) {
                    nums[j] -= temp;
                }
                if (j == nums.length - 1 && nums[j] == 0) { //added this for second submission
                    return ++count;
                }
            }
            count++;
            /*if (allZero(nums)) {
                return count;
            }*/
        }
        return count;
    }

    private static boolean allZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
