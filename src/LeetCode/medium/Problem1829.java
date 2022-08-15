package LeetCode.medium;

import java.util.Arrays;

public class Problem1829 {
    //https://leetcode.com/problems/maximum-xor-for-each-query/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)));
    }

    //Runtime: 5 ms, faster than 63.45% of Java online submissions for Maximum XOR for Each Query.
    //Memory Usage: 127.1 MB, less than 80.25% of Java online submissions for Maximum XOR for Each Query.
    static int[] getMaximumXor(int[] nums, int pow) {
        int n = (int) Math.pow(2, pow) - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            nums[i] = n ^ sum;
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            int i2 = nums.length - 1 - i;
            nums[i] = nums[i2];
            nums[i2] = temp;
        }
        
        return nums;
    }
    
    //Runtime: 5 ms, faster than 63.45% of Java online submissions for Maximum XOR for Each Query.
    //Memory Usage: 149.6 MB, less than 11.76% of Java online submissions for Maximum XOR for Each Query.
    static int[] getMaximumXor1(int[] nums, int pow) {
        int n = (int) Math.pow(2, pow) - 1;
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            res[res.length - 1 - i] = n ^ sum;
        }
        return res;
    }
}
