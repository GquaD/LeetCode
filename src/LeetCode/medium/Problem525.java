package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem525 {
    //https://leetcode.com/problems/contiguous-array/description/
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1}));
        System.out.println(findMaxLength(new int[]{0,1,0}));
        System.out.println(findMaxLength(new int[]{0,1,0,1,1,1,0,0,0}));
    }

    //nnnn
    //Runtime
    //21 ms
    //Beats
    //80.75%
    //Memory
    //54.6 MB
    //Beats
    //51.47%
    static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : nums[i];;
            if (map.containsKey(sum)) max = Math.max(max, i - map.get(sum));
            else map.put(sum, i);
        }
        return max;
    }

    static int findMaxLength1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        //sum, idx
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
