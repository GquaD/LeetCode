package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2395 {
    //https://leetcode.com/problems/find-subarrays-with-equal-sum/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-subarrays-with-equal-sum/solutions/2840766/java-from-5ms-to-2ms-2-solutions/
    //Runtime
    //2 ms
    //Beats
    //80.21%
    //Memory
    //42.3 MB
    //Beats
    //25.72%
    static boolean findSubarrays(int[] nums) {
        int temp = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            nums[i] += temp;
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            temp = t;
        }
        return false;
    }

    //faster implementation can be saving into map values->indices of equal numbers
    //then comparing those numbers' adjacent numbers and their indices
    //or the sum
    //Runtime
    //5 ms
    //Beats
    //15.17%
    //Memory
    //42.2 MB
    //Beats
    //41.50%
    static boolean findSubarrays1(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[i + 1] == nums[j] + nums[j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
