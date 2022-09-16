package LeetCode.easy;

import java.util.Arrays;

/**
 * Created by Behzod on 26, March, 2021
 */
public class Problem1365 {
    public static void main(String[] args) {
        int[] one = {8,1,2,2,3};
        int[] two = {6,5,4,8};
        int[] three = {7,7,7,7};

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(one)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(two)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(three)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int countCurrent = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (nums[i] > nums[j]) countCurrent++;
            }
            result[i] = countCurrent;
        }
        return result;
    }

    // O (n^2)
}
