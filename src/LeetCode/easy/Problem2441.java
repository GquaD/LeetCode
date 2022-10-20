package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2441 {
    //https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/solutions/2725291/java-solution/
    //Runtime
    //12 ms
    //Beats
    //57.78%
    //Memory
    //53.9 MB
    //Beats
    //5.76%

    static int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = -1;
        for (Integer n : set) {
            if (set.contains(-n) && Math.abs(n) > max) {
                max = Math.abs(n);
            }
        }
        return max;
    }
}
