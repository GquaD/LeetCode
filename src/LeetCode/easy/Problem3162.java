package LeetCode.easy;

public class Problem3162 {
    //https://leetcode.com/problems/find-the-number-of-good-pairs-i/


    //2min
    //Runtime
    //1
    //ms
    //Beats
    //99.94%
    //of users with Java
    //Memory
    //43.08
    //MB
    //Beats
    //19.71%
    //of users with Java
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            int div = nums2[i] * k;
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] % div == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
