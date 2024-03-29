package LeetCode.easy;

import LeetCode.Recursion.BinaryTreeSearch;

import java.util.Arrays;

public class Problem704 {
    //https://leetcode.com/problems/binary-search/

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0,3,5,9,23}, 9));
        System.out.println(search(new int[]{-1, 0,3,5,9,23}, 2));
    }

    static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2, curr = nums[mid];
            if (curr == target) return mid;
            else if (curr < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
    //Memory Usage: 54.7 MB, less than 20.40% of Java online submissions for Binary Search.
    static int search1(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result < 0 ? -1 : result;
    }
}
