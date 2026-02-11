package LeetCode.medium;

import java.util.*;

public class Problem3837 {
    //15min
    //Runtime
    //66
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //122.75
    //MB
    //Beats
    //-%

    public int[] delayedCount(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> indices = map.get(n);
            if (indices == null) {
                indices = new ArrayList<>();
                map.put(n, indices);
            }
            indices.add(i);
        }

        int[] ans = new int[nums.length];
        for (int key : map.keySet()) {
            List<Integer> indices = map.get(key);

            for (int i = 1; i < indices.size(); i++) {
                int base = indices.get(i - 1);
                int idx = Collections.binarySearch(indices, base + k);
                if (idx >= 0) idx++;
                else idx = -idx - 1;

                if (idx < indices.size()) ans[base] = indices.size() - idx;
            }
        }
        return ans;
    }
}
