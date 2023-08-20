package LeetCode.medium;

public class Problem2541 {
    //https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3));
    }

    //https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/solutions/3937440/java-o-n-100-faster-solution/
    //5-10 min
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //57.7 MB
    //Beats
    //81.30%
    static long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            for (int i = 0; i < nums1.length; i++)
                if (nums1[i] != nums2[i]) return -1;
            return 0;
        }
        long toSubstract = 0, toAdd = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums2[i] - nums1[i];
            if (diff % k != 0) return -1;
            if (diff > 0) toAdd += diff;
            else toSubstract += -diff;
        }

        if (toAdd != toSubstract) return -1;
        return toAdd / k;
    }
}
