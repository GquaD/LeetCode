package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem4038 {
    //15min

    //Runtime
    //2
    //ms
    //Beats
    //43.71%
    //Memory
    //43.51
    //MB
    //Beats
    //87.72%
    private static Map<Integer, Integer> map = new HashMap<>();

    public int countSpecialIntegers(int[] nums) {
        int prev = nums[0], count = 0;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (prev != curr)
                map.put(prev, map.getOrDefault(prev, 0) + 1);
            prev = curr;
        }

        map.put(prev, map.getOrDefault(prev, 0) + 1);

        for (Integer n: map.keySet())
            if (map.get(n) == 1)
                count++;

        map.clear();
        return count;
    }
}
