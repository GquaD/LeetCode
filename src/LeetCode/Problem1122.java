package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Problem1122 {
    //https://leetcode.com/problems/relative-sort-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21})));
    }

    //Runtime: 4 ms, faster than 51.74% of Java online submissions for Relative Sort Array.
    //Memory Usage: 43.2 MB, less than 26.32% of Java online submissions for Relative Sort Array.
    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int key = arr1[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int countForArr2 = 0;
        int indexStop = 0;
        for (int i = 0; i < arr1.length && countForArr2 < arr2.length; i++) {
            int currInsert = arr2[countForArr2];
            if (map.containsKey(currInsert) && map.get(currInsert) > 0) {
                arr1[i] = currInsert;
                map.put(currInsert, map.get(currInsert) - 1);
                if (map.get(currInsert) == 0) {
                    countForArr2++;
                }
            } else if (!map.containsKey(currInsert)) {
                indexStop = i;
                break;
            }
            indexStop++;
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                for (int i = 0; i < map.get(key); i++) {
                    arr1[indexStop++] = key;
                }
            }
        }
        return arr1;
    }
}
