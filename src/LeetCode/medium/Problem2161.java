package LeetCode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2161 {
    //https://leetcode.com/problems/partition-array-according-to-given-pivot/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(Arrays.toString(pivotArray(new int[]{-3, 4, 3, 2}, 2)));
    }

    //15 mins to solve
    //Runtime: 39 ms, faster than 11.25% of Java online submissions for Partition Array According to Given Pivot.
    //Memory Usage: 170.1 MB, less than 10.67% of Java online submissions for Partition Array According to Given Pivot.
    static int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> equal = new LinkedList<>();
        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> greater = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                equal.add(nums[i]);
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            } else {
                less.add(nums[i]);
            }
        }
        int count = 0;
        while (!less.isEmpty()) {
            int temp = less.poll();
            nums[count++] = temp;
        }
        while (!equal.isEmpty()) {
            int temp = equal.poll();
            nums[count++] = temp;
        }
        while (!greater.isEmpty()) {
            int temp = greater.poll();
            nums[count++] = temp;
        }
        return nums;
    }
}
