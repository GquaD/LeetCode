package LeetCode.easy;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class Problem2053 {
    //https://leetcode.com/problems/kth-distinct-string-in-an-array/
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a" }, 2));
    }

    //Runtime: 9 ms, faster than 60.51% of Java online submissions for Kth Distinct String in an Array.
    //Memory Usage: 45.2 MB, less than 45.04% of Java online submissions for Kth Distinct String in an Array.
    static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int count = 1;
        for (String key : map.keySet()) {
            if (map.get(key) == 1 && count == k) {
                return key;
            }
            if (map.get(key) == 1) {
                count++;
            }
        }
        return "";
    }
}
