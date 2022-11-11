package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem217 {
    //https://leetcode.com/problems/contains-duplicate/description/
    public static void main(String[] args) {

    }
    //overall 15 mins
    //https://leetcode.com/problems/contains-duplicate/solutions/2802591/java-98-faster-2-solutions-from-13ms-to-5ms/
    //Runtime
    //5 ms
    //Beats
    //98.26%
    //Memory
    //55.2 MB
    //Beats
    //86.78%
    static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean isEven = nums.length % 2 == 0;
        int half = nums.length / 2;
        for (int i = 0; i < half; i++) {
            int l = nums[i], r = nums[nums.length - i - 1];
            if (set.contains(l)) return true;
            else set.add(l);
            if (set.contains(r)) return true;
            else set.add(r);
        }
        if (!isEven && set.contains(nums[half])) return true;
        return false;
    }

    //Runtime
    //13 ms
    //Beats
    //83.40%
    //Memory
    //73 MB
    //Beats
    //7.57%
    static boolean containsDuplicate1(int[] nums) {
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
