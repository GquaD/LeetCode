package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4048 {
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //66.68%
    //Memory
    //46.36
    //MB
    //Beats
    //88.73%

    public int countSpecialIntegers(int[] nums) {
        //num -> list of indexes
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            List<Integer> list = map.get(cur);
            if (list == null) {
                list = new ArrayList<>();
                map.put(cur, list);
            }

            list.add(i);
        }

        int res = 0;
        for (int key: map.keySet()) {
            List<Integer> list = map.get(key);

            if (list.size() == 3 && list.get(1) - list.get(0) == list.get(2) - list.get(1)) res++;
        }

        return res;
    }
}
