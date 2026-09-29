package LeetCode.hard;

public class Problem4 {
    //https://leetcode.com/problems/median-of-two-sorted-arrays/
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,10}, new int[]{7,8,9}));
    }

    //10min
    //O(N) solution
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //48.82
    //MB
    //Beats
    //51.49%
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];

        int i = 0, l = 0, r = 0;
        while (i < arr.length) {
            if (l >= nums1.length) {
                arr[i] = nums2[r++];
            } else if (r >= nums2.length) {
                arr[i] = nums1[l++];
            } else if (nums1[l] <= nums2[r]) {
                arr[i] = nums1[l++];
            } else {
                arr[i] = nums2[r++];
            }
            i++;
        }

        int mid = arr.length / 2;
        return arr.length % 2 == 1 ? arr[mid] : (arr[mid - 1] + arr[mid]) / 2.0;
    }

    //https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2633220/Java-O(N)-solution-or-75-faster-or-Explained
    //20-30min
    //Runtime: 4 ms, faster than 75.31% of Java online submissions for Median of Two Sorted Arrays.
    //Memory Usage: 50 MB, less than 45.06% of Java online submissions for Median of Two Sorted Arrays.
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums2.length + nums1.length];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            a = count1 < nums1.length ? nums1[count1] : a;
            b = count2 < nums2.length ? nums2[count2] : b;
            if (a <= b) {
                arr[i] = a;
                count1++;
            } else {
                arr[i] = b;
                count2++;
            }
        }
        if (arr.length % 2 == 0) {
            return ((arr[(arr.length - 1)/2] + arr[arr.length/2]) * 1.0) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }
}
