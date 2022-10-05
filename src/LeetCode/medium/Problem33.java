package LeetCode.medium;

import java.util.Arrays;

public class Problem33 {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 3));
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 0));
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 7));
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 8));
        System.out.println(search(new int[]{7,0,1,2,4,5,6}, 7));
        System.out.println(search(new int[]{1}, 0));
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/2662980/java-o-n-log-n-solution-explained-79-faster/
    //15 mins
    //1 ms
    //Beats
    //79.36%
    //Memory
    //42.2 MB
    //Beats
    //73.88%
    static int search(int[] nums, int target) {
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
            }
        }
        if (index == -1) {
            int res = Arrays.binarySearch(nums, target);
            return Math.max(res, -1);
        } else {
            int left = Arrays.binarySearch(nums, 0, index, target);
            int right = Arrays.binarySearch(nums, index, nums.length, target);
            if (left < 0 && right < 0) {
                return -1;
            } else return Math.max(left, right);
        }
    }
}
