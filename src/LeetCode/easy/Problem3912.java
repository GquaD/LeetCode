package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3912 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //46.36
    //MB
    //Beats
    //99.69%
    //https://leetcode.com/problems/valid-elements-in-an-array/solutions/8108072/java-100-fast-solution-by-tbekpro-4jt9/
    public List<Integer> findValidElements(int[] nums) {
        int[] arr = new int[nums.length];

        int max = nums[nums.length  - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(nums[i + 1], max);
            arr[i] = max;
        }

        max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (max < cur || cur > arr[i]) {
                list.add(cur);
                max = cur;
            }
        }

        return list;
    }
}
