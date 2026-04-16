package LeetCode.medium;

import java.util.*;

public class Problem3488 {
    //25min

    //Runtime
    //94
    //ms
    //Beats
    //75.76%
    //Memory
    //185.80
    //MB
    //Beats
    //68.69%
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        //value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i], val = nums[idx];
            int left = idx, right = idx;

            List<Integer> list = map.get(val);
            if (list == null || list.size() == 1) {
                result.add(-1);
                continue;
            } else if (list.size() == 2) {
                left = list.get(0);
                right = list.get(1);
                result.add(Math.min(right - left, left + nums.length - right));
            } else {
                int idxList = Collections.binarySearch(list, idx);

                if (idxList == list.size() - 1) {
                    right = list.get(0);
                    left = list.get(idxList - 1);
                } else if (idxList == 0) {
                    right = list.get(idxList + 1);
                    left = list.get(list.size() - 1);
                } else {
                    right = list.get(idxList + 1);
                    left = list.get(idxList - 1);
                }

                int res = Math.min(Math.min(Math.abs(idx - right), Math.abs(right - idx + nums.length)), Math.min(Math.abs(idx - left), idx + nums.length - left));
                result.add(res);
            }
        }

        return result;
    }
}
