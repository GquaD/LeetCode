package LeetCode.medium;

public class Problem1855 {
    //https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
    }

    //nnnn
    //Runtime
    //4 ms
    //Beats
    //49.49%
    //Memory
    //58.5 MB
    //Beats
    //16.16%
    static int maxDistance(int[] nums1, int[] nums2) {
        int r = 0, l = 0, max = 0;
        while(r < nums2.length && l < nums1.length) {
            if (nums2[r] < nums1[l]) {
                l++;
            } else {
                max = Math.max(max, r++ - l);
            }
        }
        return max;
    }
    //Wrong Answer
    //    //31 / 32 testcases passed
    static int maxDistance1(int[] nums1, int[] nums2) {
        int r = nums2.length - 1, l = 0, max = 0;
        while (l <= r) {
            if(nums1[l] <= nums2[r]){
                max = Math.max(0, r - l);
                break;
            } else {
                l++;
            }
        }
        r = nums2.length - 1;
        l = 0;
        while (l <= r) {
            if(nums1[l] <= nums2[r]){
                max = Math.max(max, r - l);
                break;
            } else {
                r--;
            }
        }
        return max;
    }
}
