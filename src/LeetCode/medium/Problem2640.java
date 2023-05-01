package LeetCode.medium;

import java.util.Arrays;

public class Problem2640 {
    //https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPrefixScore(new int[]{2,3,7,5,10})));;
    }

    //https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/solutions/3471851/java-100-faster-solution/
    //10-15min
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //65.2 MB
    //Beats
    //34.52%
    static long[] findPrefixScore(int[] nums) {
        long conver[] = new long[nums.length], max = nums[0];
        conver[0] = nums[0] + max;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
            conver[i] = nums[i] + max + conver[i - 1];
        }
        return conver;
    }
}
