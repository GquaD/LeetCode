package LeetCode.medium;

import java.util.Arrays;

public class Problem81 {
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solutions/2970283/java-2-line-100-faster-solution/
    //5 + 2 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42 MB
    //Beats
    //85.74%

    static boolean search(int[] nums, int target) {
        for (int n : nums) if (n == target) return true;
        return false;
    }

    //Runtime
    //1 ms
    //Beats
    //71.42%
    //Memory
    //42.4 MB
    //Beats
    //72%
    static boolean search1(int[] nums, int target) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                k = i;
                break;
            }
        }
        int idx1 = Arrays.binarySearch(nums, 0, k, target);
        int idx2 = Arrays.binarySearch(nums, k, nums.length, target);
        return idx1 > -1 || idx2 > -1;
    }
}
