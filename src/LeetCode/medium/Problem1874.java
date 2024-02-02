package LeetCode.medium;

import java.util.Arrays;

public class Problem1874 {
    //https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimize-product-sum-of-two-arrays/solutions/4665933/java-5-lines-solution/
    //5min
    //Runtime
    //23
    //ms
    //Beats
    //73.43%
    //of users with Java
    //Memory
    //64.34
    //MB
    //Beats
    //27.97%
    //of users with Java
    static int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0, n = nums1.length;
        for (int i = 0; i < n; i++) res += nums1[i] * nums2[n - i - 1];
        return res;
    }
}
