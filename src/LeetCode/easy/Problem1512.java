package LeetCode.easy;

import java.util.Arrays;

/**
 * Created by Behzod on 25, March, 2021
 */
public class Problem1512 {
    public static void main(String[] args) {
        int[] one = {1,2,3,1,1,3};
        int[] two = {1,1,1,1};
        int[] three = {1,2,3};
        System.out.println(numIdenticalPairs(one));
        System.out.println(numIdenticalPairs(two));
        System.out.println(numIdenticalPairs(three));
    }

    public static int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int number = nums[0], frequency = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number) {
                frequency++;
            } else {
                frequency--;
                sum +=  ((frequency * (frequency + 1)) / 2);
                frequency = 0;
                number = nums[i];
                i--;
            }
            if (i == nums.length - 1) {
                frequency--;
                sum +=  ((frequency * (frequency + 1)) / 2);
            }
        }
        return sum;
    }
    //complexity O(n logn)
}
