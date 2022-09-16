package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1207 {
    //https://leetcode.com/problems/unique-number-of-occurrences/
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
    }

    //Runtime: 2 ms, faster than 94.86% of Java online submissions for Unique Number of Occurrences.
    //Memory Usage: 42.9 MB, less than 8.05% of Java online submissions for Unique Number of Occurrences.
    static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (!set.add(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}
