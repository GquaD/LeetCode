package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem136 {
    //solution for https://leetcode.com/problems/single-number/
    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 2, 1, 2, 1}));
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumber(new int[]{2, 3, 1, 4, 1, 2, 3}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], (map.get(nums[i]) + 1));
            }
        }

        return map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
    }
}
