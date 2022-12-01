package LeetCode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2465 {
    //https://leetcode.com/problems/number-of-distinct-averages/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-distinct-averages/solutions/2865225/java-from-5ms-to-2ms-2-solutions/
    //Runtime
    //2 ms
    //Beats
    //82.32%
    //Memory
    //39.9 MB
    //Beats
    //90.66%
    static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        List<Float> list = new ArrayList<>();
        int half = nums.length / 2;
        for (int i = 0; i < half; i++) {
            list.add((nums[i] + nums[nums.length - 1 - i]) / 2.0F);
        }
        return (int) list.stream().distinct().count();
    }
}
