package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2670 {
    //https://leetcode.com/problems/find-the-distinct-difference-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctDifferenceArray(new int[]{1,2,3,4,5})));
    }

    //https://leetcode.com/problems/find-the-distinct-difference-array/solutions/3542157/java-using-2-hashsets/
    //5-10 min
    //Runtime
    //13 ms
    //Beats
    //37.28%
    //Memory
    //44.8 MB
    //Beats
    //5.41%
    static int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> pre = new HashSet<>(), post = new HashSet<>();
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            pre.add(nums[i]);
            post = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) post.add(nums[j]);
            arr[i] = pre.size() - post.size();
        }
        for (int j = 0; j < nums.length; j++) post.add(nums[j]);
        arr[arr.length - 1] = post.size();
        return arr;
    }
}
