package LeetCode.easy;

import java.util.Arrays;

public class Problem1502 {
    //https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3,5,1}));
        System.out.println(canMakeArithmeticProgression(new int[]{1,2,4}));
    }

    //Runtime: 1 ms, faster than 99.67% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    //Memory Usage: 40.4 MB, less than 94.97% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
