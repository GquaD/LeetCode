package LeetCode.medium;

public class Problem3865 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //-%
    //Memory
    //47.33
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/reverse-k-subarrays/solutions/7638873/java-1ms-solution-by-tbekpro-tw4i/
    public int[] reverseSubarrays(int[] nums, int k) {
        int len = nums.length / k;
        for (int i = 0; i < nums.length; i += len) {
            for (int j = 0; j < len / 2; j++) {
                int temp = nums[i + j];
                nums[i + j] = nums[i + len - j - 1];
                nums[i + len - j - 1] = temp;
            }
        }
        return nums;
    }
}
