package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3940 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //46.62
    //MB
    //Beats
    //93.54%
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0, curr = nums[0], idx = 0, len = nums.length;

        while (idx < len) {
            if (count++ < k && curr == nums[idx]) {
                list.add(curr);
            } else if (idx < len && curr != nums[idx]) {
                curr = nums[idx];
                list.add(curr);
                count = 1;
            }
            idx++;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
