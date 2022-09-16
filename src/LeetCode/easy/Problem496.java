package LeetCode.easy;

import java.util.Arrays;

public class Problem496 {
    //https://leetcode.com/problems/next-greater-element-i/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }

    //Runtime: 4 ms, faster than 82.10% of Java online submissions for Next Greater Element I.
    //Memory Usage: 44.3 MB, less than 52.29% of Java online submissions for Next Greater Element I.
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int temp = nums1[i];
            boolean notFound = true;
            int index = findIndexOf(temp, nums2);
            for (int j = index; j < nums2.length; j++) {
                if (temp < nums2[j]) {
                    nums1[i] = nums2[j];
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                nums1[i] = -1;
            }
        }
        return nums1;
    }

    static int findIndexOf(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
