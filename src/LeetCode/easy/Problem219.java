package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem219 {
    //https://leetcode.com/problems/contains-duplicate-ii/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/contains-duplicate-ii/solutions/2728060/java-3-approaches-to-one-solution-from-8-to-70/
    //overall to three solution less than 30 mins
    //Runtime
    //41 ms
    //Beats
    //69.96%
    //Memory
    //95.3 MB
    //Beats
    //19.65%
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        //key -> value - num -> last index, since it is just enough to check with last idx, because previous case has been checked
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                int idx = map.get(key);
                if (i - idx <= k) {
                    return true;
                }
                map.put(key, i);
            } else {
                map.put(key, i);
            }
        }

        return false;
    }

    //Runtime
    //85 ms
    //Beats
    //10.35%
    //Memory
    //105 MB
    //Beats
    //5.2%
    static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k == 0) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                List<Integer> indices = map.get(key);
                if (i - indices.get(indices.size() - 1) <= k) {
                    return true;
                }
                map.get(key).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(key, indices);
            }
        }

        return false;
    }

    //Runtime
    //133 ms
    //Beats
    //7.69%
    //Memory
    //119.3 MB
    //Beats
    //5.2%
    static boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (k == 0) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(key, indices);
            }
        }

        for (Integer key : map.keySet()) {
            List<Integer> indices = map.get(key);
            if (indices.size() > 1) {
                for (int i = 1; i < indices.size(); i++) {
                    if (indices.get(i) - indices.get(i - 1) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
