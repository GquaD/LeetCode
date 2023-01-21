package LeetCode.easy;

public class Problem2529 {
    //https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
    public static void main(String[] args) {

    }

    //
    //3 min
    //Runtime
    //1 ms
    //Beats
    //36.7%
    //Memory
    //42.2 MB
    //Beats
    //78.46%
    static int maximumCount(int[] nums) {
        int countN = 0, countP = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) countP++;
            if (nums[i] < 0) countN++;
        }
        return Math.max(countN, countP);
    }
}
