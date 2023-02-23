package LeetCode.medium;

import java.util.Arrays;

public class Problem238 {
    //https://leetcode.com/problems/product-of-array-except-self/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    //10-15 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //61 MB
    //Beats
    //5.35%
    static int[] productExceptSelf(int[] nums) {
        int countZero = 0, mult = 1;
        for (int n : nums) {
            if (n == 0) countZero++;
            else mult *= n;
        }
        if (countZero < 2) {
            if (countZero == 1) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) nums[i] = mult;
                    else nums[i] = 0;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = mult / nums[i];
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
        return nums;
    }
}
