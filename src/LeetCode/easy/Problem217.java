package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem217 {
    //https://leetcode.com/problems/contains-duplicate/description/
    public static void main(String[] args) {

    }



    //Runtime
    //13 ms
    //Beats
    //83.40%
    //Memory
    //73 MB
    //Beats
    //7.57%
    static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isEven = nums.length % 2 == 0;
        int half = nums.length / 2;
        for (int i = 0; i < half; i++) {
            int l = nums[i], r = nums[nums.length - i - 1];
            if (map.containsKey(l)) return true;
            else map.put(l, 1);
            if (map.containsKey(r)) return true;
            else map.put(r, 1);
        }
        if (!isEven && map.containsKey(nums[half])) return true;
        return false;
    }
}
