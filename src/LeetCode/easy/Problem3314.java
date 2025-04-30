package LeetCode.easy;

import java.util.List;

public class Problem3314 {
    //https://leetcode.com/problems/construct-the-minimum-bitwise-array-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/solutions/6702006/java-brute-force-solution-by-tbekpro-bm16/
    //5min
    //Runtime
    //3
    //ms
    //Beats
    //68.20%
    //Analyze Complexity
    //Memory
    //44.74
    //MB
    //Beats
    //78.24%
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) arr[i] = -1;
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            for (int j = 0; j < cur; j++) {
                if ((j | (j + 1)) == cur) {
                    arr[i] = j;
                    break;
                }
            }
        }
        return arr;
    }
}
