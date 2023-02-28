package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem2570 {
    //https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/solutions/3238538/java-map/
    //15 min
    //Runtime
    //4 ms
    //Beats
    //45.62%
    //Memory
    //43.6 MB
    //Beats
    //7.65%
    static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : nums1) map.put(arr[0], arr[1]);

        for (int[] arr : nums2) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
//            if (map.containsKey(arr[0])) map.put(arr[0], map.get(arr[0]) + arr[1]);
//            else map.put(arr[0], arr[1]);
        }

        int[][] res = new int[map.size()][2];
        int count = 0;
        for (int key : map.keySet()) {
            res[count][0] = key;
            res[count++][1] = map.get(key);
        }
        return res;
    }
}
