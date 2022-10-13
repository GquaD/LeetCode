package LeetCode.easy;

import java.util.Arrays;

public class Problem88 {
    //https://leetcode.com/problems/merge-sorted-array/
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println("///////////");

        int[] nums2 = {1,2,6,0,0,0};
        merge(nums2, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(nums2));
        System.out.println("///////////");
    }

    //Runtime
    //2 ms
    //Beats
    //24.16%
    //Memory
    //43 MB
    //Beats
    //39.60%
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int c = 0;
        while (m < nums1.length) {
            nums1[m++] = nums2[c++];
        }
        Arrays.sort(nums1);
    }

    static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int count = 0, count2 = 0;
        while (count < m) {
            if (nums1[count] <= nums2[count2]) {
                count++;
            } else {
                int temp = nums1[count];
                nums1[count] = nums2[count2];
                nums2[count2] = temp;
                count++;
                count2++;
                count2 %= n;
            }
        }
        int c = 0;
        while (m < nums1.length) {
            nums1[m++] = nums2[c++];
        }
    }
}
