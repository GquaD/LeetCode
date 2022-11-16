package LeetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem268 {
    //https://leetcode.com/problems/missing-number/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/missing-number/solutions/2819778/java-o-n-n-solution/
    //10 mins
    //Runtime
    //6 ms
    //Beats
    //30.73%
    //Memory
    //42.8 MB
    //Beats
    //97.48%
    static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return 0;
    }

    static int missingNumber1(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 0) return 1;
            else return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i + 1] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
