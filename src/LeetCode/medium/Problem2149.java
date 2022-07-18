package LeetCode.medium;

import java.util.Arrays;

public class Problem2149 {
    //https://leetcode.com/problems/rearrange-array-elements-by-sign/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{-1, 1})));
    }

    //Runtime: 12 ms, faster than 32.65% of Java online submissions for Rearrange Array Elements by Sign.
    //Memory Usage: 201.4 MB, less than 77.67% of Java online submissions for Rearrange Array Elements by Sign.
    static int[] rearrangeArray(int[] nums) {
        //split into two arrays with neg and pos ints
        //then fill new array in proper order
        int[] neg = new int[nums.length / 2], pos = new int[nums.length / 2];
        int negCount = 0, posCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg[negCount++] = nums[i];
            } else {
                pos[posCount++] = nums[i];
            }
        }
        posCount = 0;
        negCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = pos[posCount++];
            } else {
                nums[i] = neg[negCount++];
            }
        }
        return nums;
    }

}
