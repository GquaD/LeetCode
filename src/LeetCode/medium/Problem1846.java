package LeetCode.medium;

import java.util.Arrays;

public class Problem1846 {
    //https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(
                new int[]{2,2,2,2,2,2,2,2}
        ));
    }

    static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 0;
        for (int n : arr) max = Math.max(n, max);
        return Math.min(arr.length, max);
    }

    //https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/solutions/3634866/java-straightforward-solution/
    //15-20 min
    //Runtime
    //6 ms
    //Beats
    //68.22%
    //Memory
    //56.4 MB
    //Beats
    //86.11%
    static int maximumElementAfterDecrementingAndRearranging1(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) if (arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
        return arr[arr.length - 1];
    }
}
