package LeetCode;

import java.util.*;

public class Problem2032 {
    //https://leetcode.com/problems/two-out-of-three/
    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
        System.out.println(twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
    }

    //Runtime: 19 ms, faster than 9.30% of Java online submissions for Two Out of Three.
    //Memory Usage: 49.1 MB, less than 5.31% of Java online submissions for Two Out of Three.
    static Map<Integer, Integer> map;

    static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        map = new HashMap<>();
        putIntoMap(nums1);
        putIntoMap(nums2);
        putIntoMap(nums3);
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }
        return list;
    }

    private static void putIntoMap(int[] nums) {
        nums = Arrays.stream(nums).distinct().toArray();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
    }


}
