package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem350 {
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/intersection-of-two-arrays-ii/solutions/2862073/java-from-13ms-to-5ms-2-solutions/

    //Runtime
    //5 ms
    //Beats
    //70.8%
    //Memory
    //43.9 MB
    //Beats
    //52.83%
    static int[] arr1 = new int[1001];
    static int[] arr2 = new int[1001];

    public int[] intersect(int[] nums1, int[] nums2) {
        clearArrays();
        for (int n : nums1) {
            arr1[n]++;
        }
        for (int n : nums2) {
            arr2[n]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int k = Math.min(arr1[i], arr2[i]);
            for (int j = 0; j < k; j++) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void clearArrays() {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 0;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 0;
        }
    }


    //5-10min
    //Runtime
    //13 ms
    //Beats
    //9.97%
    //Memory
    //44.9 MB
    //Beats
    //5.89%
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int n : nums1) {
            if (map1.containsKey(n)) {
                map1.put(n, map1.get(n) + 1);
            } else {
                map1.put(n, 1);
            }
        }
        for (int n : nums2) {
            if (map2.containsKey(n)) {
                map2.put(n, map2.get(n) + 1);
            } else {
                map2.put(n, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            Integer f1 = map1.get(key), f2 = map2.get(key);
            if (f2 != null) {
                f1 = Math.min(f1, f2);
                for (int i = 0; i < f1; i++) {
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
