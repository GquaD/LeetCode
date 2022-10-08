package LeetCode.easy;

import java.util.Arrays;

public class Problem35 {
    //https://leetcode.com/problems/search-insert-position/
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, -1));
    }


    //less than 5 mins
    //https://leetcode.com/problems/search-insert-position/solutions/2675868/java-just-2-lines-100-faster/

    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43.6 MB
    //Beats
    //32.57%
    static int searchInsert(int[] nums, int target) {
        int n = Arrays.binarySearch(nums, target);
        return n >= 0 ? n : -n - 1;
    }
}
