package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2515 {
    //5min

    //Runtime
    //4
    //ms
    //Beats
    //1.95%
    //Memory
    //47.01
    //MB
    //Beats
    //28.57%
    public int closestTarget(String[] words, String target, int idx) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            List<Integer> list = map.get(w);
            if (list == null) {
                list = new ArrayList<>();
                map.put(w, list);
            }

            list.add(i);
        }

        List<Integer> list = map.get(target);
        if (list == null) return -1;

        int min = words.length;
        for (int i: list) {
            min = Math.min(min, Math.min(Math.abs(idx - i), Math.min(words.length - idx + i, words.length - i + idx)));
        }
        return min;
    }
}
