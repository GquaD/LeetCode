package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4049 {
    //5-10min

    //Runtime
    //102
    //ms
    //Beats
    //43.60%
    //Memory
    //252.89
    //MB
    //Beats
    //54.38%
    public int countSpecialIntegers(int[] nums) {
        //num -> list of indexes
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            List<Integer> idxs = map.get(key);
            if (idxs == null) {
                idxs = new ArrayList<>();
                map.put(key, idxs);
            }
            idxs.add(i);
        }

        int res = 0;
        for (int key: map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() > 2) {
                boolean isEqual = true;
                for (int i = 1; i < list.size() - 1; i++) {
                    if (list.get(i) - list.get(i - 1) != list.get(i + 1) - list.get(i)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) res++;
            }
        }

        return res;
    }
}
