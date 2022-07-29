package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2032 {
    //https://leetcode.com/problems/two-out-of-three/
    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
        System.out.println(twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2}));
    }

    //Runtime: 9 ms, faster than 51.57% of Java online submissions for Two Out of Three.
    //Memory Usage: 46.6 MB, less than 62.68% of Java online submissions for Two Out of Three.
    static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>(); //or use set
        findInOtherArrays(nums1, nums2, nums3, set);
//        findInOtherArrays(nums2, nums1, nums3, set);
//        findInOtherArrays(nums3, nums2, nums1, set);
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums3.length; j++) {
                if (nums2[i] == nums3[j]) {
                    set.add(nums2[i]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private static void findInOtherArrays(int[] nums1, int[] nums2, int[] nums3, Set<Integer> set) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
            for (int j = 0; j < nums3.length; j++) {
                if (nums1[i] == nums3[j]) {
                    set.add(nums1[i]);
                }
            }
        }
    }

    //Runtime: 25 ms, faster than 5.68% of Java online submissions for Two Out of Three.
    //Memory Usage: 46.9 MB, less than 52.78% of Java online submissions for Two Out of Three.
    static List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>(); //or use set
        findInOtherArrays2(nums1, nums2, nums3, list);
        findInOtherArrays2(nums2, nums1, nums3, list);
        findInOtherArrays2(nums3, nums2, nums1, list);
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static void findInOtherArrays2(int[] nums1, int[] nums2, int[] nums3, List<Integer> list) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }
            }
            for (int j = 0; j < nums3.length; j++) {
                if (nums1[i] == nums3[j]) {
                    list.add(nums1[i]);
                }
            }
        }
    }

    //Runtime: 19 ms, faster than 9.30% of Java online submissions for Two Out of Three.
    //Memory Usage: 49.1 MB, less than 5.31% of Java online submissions for Two Out of Three.
    static Map<Integer, Integer> map;

    static List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
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
