package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3880 {
    //2min

    //Runtime
    //2
    //ms
    //Beats
    //-%
    //Memory
    //46.32
    //MB
    //Beats
    //-%
    public int minAbsoluteDifference(int[] nums) {
        List<Integer> ones = new ArrayList<>(), twos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) ones.add(i);
            else if (nums[i] == 2) twos.add(i);
        }

        int min = nums.length;
        for (int i = 0; i < ones.size(); i++) {
            for (int j = 0; j < twos.size(); j++) {
                min = Math.min(min, Math.abs(ones.get(i) - twos.get(j)));
            }
        }

        return min == nums.length ? -1 : min;
    }
}
