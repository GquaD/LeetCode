package LeetCode.easy;

import java.util.Arrays;

public class Problem27 {
    //https://leetcode.com/problems/remove-element/
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{1}, 1));
        System.out.println(removeElement(new int[]{3,3}, 3));
    }


    //https://leetcode.com/problems/remove-element/solutions/2650700/java-average-solution/
    //30 mins
    /*Runtime
        2 ms
        Beats
        5.83%
        Memory
        40.9 MB
        Beats
        89.30%
    */
    static int removeElement(int[] nums, int val) {
        int count = 0, edge = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (edge > 0) {
                    if (nums[edge] != val) {
                        nums[i] = nums[edge];
                        edge--;
                        break;
                    }
                    edge--;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }
}
