package LeetCode.easy;

import java.util.Arrays;

public class Problem26 {
    //solution for https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{1,1,2}));
        System.out.println(removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/2802478/java-100-faster-solution/
    public static int removeDuplicates(int[] nums) {
        int[] result = new int[nums.length];
        int temp = nums[0], count = 0;
        result[count] = temp;
        for (int i = 1; i < nums.length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                result[++count] = temp;
            }
        }
        nums = result;
        System.out.println(Arrays.toString(nums));
        return count + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int temp = nums[0], count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (temp != nums[i]) {
                temp = nums[i];
                nums[++count] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        return ++count;
    }
}
