package LeetCode;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by Behzod on 24, March, 2021
 */
public class Problem1480 {
    public static void main(String[] args) {
        int[] one = new int[] {1, 2, 3, 4};
        int[] two = new int[] {1, 2, 3, 4, 5};
        int[] three = new int[] {1, 1, 1, 1, 1};
        int[] four = new int[] {3, 1, 2, 10, 1};

        System.out.println(Arrays.toString(runningSum(one)));
        System.out.println(Arrays.toString(runningSum(two)));
        System.out.println(Arrays.toString(runningSum(three)));
        System.out.println(Arrays.toString(runningSum(four)));
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
