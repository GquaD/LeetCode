package LeetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1748 {
    //https://leetcode.com/problems/sum-of-unique-elements/
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(sumOfUnique(new int[]{1,1,1,1,1}));
        System.out.println(sumOfUnique(new int[]{1,2,3,4,5}));
    }

    //Runtime: 3 ms, faster than 32.97% of Java online submissions for Sum of Unique Elements.
    //Memory Usage: 41.5 MB, less than 72.15% of Java online submissions for Sum of Unique Elements.
    static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int sum = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                sum += key;
            }
        }
        return sum;
    }
}
