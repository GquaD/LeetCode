package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem3978 {
    //1min

    //Runtime
    //3
    //ms
    //Beats
    //100.00%
    //Memory
    //46.27
    //MB
    //Beats
    //100.00%
    public boolean isMiddleElementUnique(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length / 2; i++) {
            set.add(nums[i]);
        }

        for (int i = nums.length / 2 + 1; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return !set.contains(nums[nums.length / 2]);
    }
}
