package LeetCode.medium;

import java.util.*;

public class Problem3011 {
    //https://leetcode.com/problems/find-if-array-can-be-sorted/
    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{75,34,30}));
        System.out.println(canSortArray(new int[]{8,4,2,30,15}));
        System.out.println(canSortArray(new int[]{1,2,3,4,5}));
        System.out.println(canSortArray(new int[]{3,16,8,4,2}));
    }

    //https://leetcode.com/problems/find-if-array-can-be-sorted/solutions/4619615/java-o-nlogn/
    //35min
    //Runtime
    //3
    //ms
    //Beats
    //92.15%
    //of users with Java
    //Memory
    //44.75
    //MB
    //Beats
    //27.19%
    //of users with Java
    static boolean canSortArray(int[] nums) {
        Arrays.sort(nums, 0, 1);
        int a = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = Integer.bitCount(nums[i - 1]), y = Integer.bitCount(nums[i]);
            if (x != y) {
                Arrays.sort(nums, a, i);
                a = i;
            }
        }
        if (a != nums.length - 1) Arrays.sort(nums, a, nums.length);

        return isSorted(nums);
    }

    private static boolean isSorted(int[] arr) {
        boolean asc = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                asc = false;
                break;
            }
        }
        return asc;
    }

    static boolean canSortArray1(int[] nums) {
        //num of bits -> list of indices
        //if (isSorted(nums)) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = Integer.bitCount(nums[i]);
            List<Integer> l = map.get(b);
            if (l == null) {
                l = new ArrayList<>();
                map.put(b, l);
            }
            l.add(i);

            List<Integer> list = mapNums.get(b);
            if (list == null) {
                list = new ArrayList<>();
                mapNums.put(b, list);
            }
            list.add(nums[i]);
        }

        for (int k : mapNums.keySet()) {
            Collections.sort(mapNums.get(k));
        }

        for (int b : map.keySet()) {
            List<Integer> lIdx = map.get(b), lNum = mapNums.get(b);
            for (int i = 0; i < lIdx.size(); i++) {
                nums[lIdx.get(i)] = lNum.get(i);
            }
        }

        return isSorted(nums);
    }
}
