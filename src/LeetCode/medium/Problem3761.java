package LeetCode.medium;

import java.util.*;

public class Problem3761 {
    //20 min

    //Runtime
    //158
    //ms
    //Beats
    //5.58%
    //Memory
    //148.94
    //MB
    //Beats
    //5.08%
    private StringBuilder sb = new StringBuilder();

    public int minMirrorPairDistance(int[] nums) {
        //number -> index
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.get(num);
            if (list == null) {
                list = new ArrayList<>();
                map.put(num, list);
            }
            list.add(i);
        }

        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.get(reverse(num));

            if (list == null)
                continue;
            if (list.size() == 1) {
                if (list.get(0) <= i)
                    continue;
                min = Math.min(min, Math.abs(i - list.get(0)));
            } else {
                int idx = Collections.binarySearch(list, i);

                if (idx < 0) {
                    idx = -idx - 1;
                    if (idx == list.size()) {
                        continue;
                    }
                    min = Math.min(min, Math.abs(i - list.get(idx)));
                } else {
                    if (idx == list.size() - 1) {
                        continue;
                    } else if (idx == 0) {
                        min = Math.min(min, Math.abs(i - list.get(1)));
                    } else {
                        min = Math.min(min, Math.abs(i - list.get(idx + 1)));
                    }
                }

            }

        }

        return min == nums.length ? -1 : min;
    }

    private int reverse(int n) {
        sb.setLength(0);

        sb.append(n);
        int result = Integer.parseInt(sb.reverse().toString());
        return result;
    }
}
