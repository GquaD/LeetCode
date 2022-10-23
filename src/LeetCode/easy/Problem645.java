package LeetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem645 {
    //https://leetcode.com/problems/set-mismatch/description/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,3,4,6,5})));
    }


    static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return new int[]{nums[i], nums[i - 1]};
            }
        }
        return null;
    }

    //Runtime
    //51 ms
    //Beats
    //6.56%
    //Memory
    //57.8 MB
    //Beats
    //8.4%
    static int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr)) {
                res[0] = curr;
            } else {
                set.add(curr);
            }
            if (!set.contains(i + 1)) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}
