package LeetCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2295 {
    //https://leetcode.com/problems/replace-elements-in-an-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3}, {4,7}, {6,1}})));
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2}, new int[][]{{1,3}, {2,1}, {3,2}})));
    }

    //https://leetcode.com/problems/replace-elements-in-an-array/solutions/4313765/java-o-n-hashmap-90-faster/
    //5-10min
    //Runtime
    //35 ms
    //Beats
    //90.36%
    //Memory
    //83.9 MB
    //Beats
    //46.19%
    static int[] arrayChange(int[] nums, int[][] operations) {
        //num -> idx
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int[] arr : operations) {
            int val1 = arr[0], val2 = arr[1], idx = map.remove(val1);
            nums[idx] = val2;
            map.put(val2, idx);
        }
        return nums;
    }
}
