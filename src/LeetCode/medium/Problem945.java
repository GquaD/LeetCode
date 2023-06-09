package LeetCode.medium;

import java.util.Arrays;

public class Problem945 {
    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(minIncrementForUnique(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/solutions/3618843/java-o-nlogn-solution/
    //5 min
    //Runtime
    //43 ms
    //Beats
    //31.82%
    //Memory
    //56 MB
    //Beats
    //32.18%
    static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] += nums[i - 1] - nums[i] + 1;
            }
        }
        return count;
    }
}
