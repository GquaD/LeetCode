package LeetCode.easy;

public class Problem3065 {
    //https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/
    public static void main(String[] args) {

    }


    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.85
    //MB
    //Beats
    //36.31%
    //of users with Java
    static int minOperations(int[] nums, int k) {
        int count = 0;
        for (int n : nums) if (n < k) count++;
        return count;
    }
}
