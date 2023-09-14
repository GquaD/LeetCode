package LeetCode.medium;

public class Problem2271 {
    //https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/
    public static void main(String[] args) {
        System.out.println(maxNonDecreasingLength(new int[]{90,27,26}, new int[]{37,92,15}));
        System.out.println(maxNonDecreasingLength(new int[]{11,7,7,9}, new int[]{19,19,1,7}));
        System.out.println(maxNonDecreasingLength(new int[]{8,7,4}, new int[]{13,4,4}));
        System.out.println(maxNonDecreasingLength(new int[]{1,3,2,1}, new int[]{2,2,3,4}));
        System.out.println(maxNonDecreasingLength(new int[]{2,3,1}, new int[]{1,2,1}));
        System.out.println(maxNonDecreasingLength(new int[]{1,1}, new int[]{2,2}));
    }

    //find a way to compute all cases at each step and calculate best choice
    //nnnn
    //Runtime
    //4 ms
    //Beats
    //98.8%
    //Memory
    //57.1 MB
    //Beats
    //67.1%
    static int maxNonDecreasingLength(int[] A, int[] B) {
        int res = 1, dp1 = 1, dp2 = 1, tempA1, tempA2, tempB1, tempB2;
        for (int i = 1; i < A.length; i++) {
            tempA1 = A[i - 1] <= A[i] ? dp1 + 1 : 1;
            tempA2 = A[i - 1] <= B[i] ? dp1 + 1 : 1;
            tempB1 = B[i - 1] <= A[i] ? dp2 + 1 : 1;
            tempB2 = B[i - 1] <= B[i] ? dp2 + 1 : 1;
            dp1 = Math.max(tempA1, tempB1);
            dp2 = Math.max(tempA2, tempB2);
            res = Math.max(res, Math.max(dp1, dp2));
        }
        return res;
    }

    //Wrong Answer
    //1954 / 2973 testcases passed
    static int maxNonDecreasingLength2(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length];
        int prev = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = Math.max(nums1[i], nums2[i]);
            arr[i] = temp <= prev ? temp : Math.min(nums1[i], nums2[i]);
            prev = arr[i];
        }
        int len = 1, max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, Math.max(len, maxNonDecreasingLength1(nums1, nums2)));
    }

    static int maxNonDecreasingLength1(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length];
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int temp = Math.max(nums1[i], nums2[i]);
            arr[i] = prev <= temp ? temp : Math.min(nums1[i], nums2[i]);
            prev = arr[i];
        }
        int len = 1, max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, len);
    }
}
