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

    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.71
    //MB
    //Beats
    //65.74%
    public int search3(int[] nums, int target) {
        //find the start point with binary search
        //then use binary search on both parts

        if (nums[0] < nums[nums.length - 1]) {
            int idx = Arrays.binarySearch(nums, target);
            return idx < 0 ? -1 : idx;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int idx1 = Arrays.binarySearch(nums, 0, left + 1, target), idx2 = Arrays.binarySearch(nums, right, nums.length, target);
        if (idx1 < 0 && idx2 < 0) return -1;

        return idx1 >= 0 ? idx1 : idx2;
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/2662980/java-o-n-log-n-solution-explained-79-faster/
    //
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
