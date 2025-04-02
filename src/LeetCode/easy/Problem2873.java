package LeetCode.easy;

public class Problem2873 {
    //https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //3
    //ms
    //Beats
    //53.95%
    //Analyze Complexity
    //Memory
    //42.09
    //MB
    //Beats
    //56.36%
    public long maximumTripletValue(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result = Math.max(result, (nums[i] - nums[j]) * 1L * nums[k]);
                }
            }
        }
        return result;
    }
}
