package LeetCode.easy;

public class Problem2574 {
    //https://leetcode.com/problems/left-and-right-sum-differences/
    public static void main(String[] args) {

    }

    //5 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.8 MB
    //Beats
    //86.91%
    static int[] leftRigthDifference(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            sum -= n;
            nums[i] = Math.abs(left - sum);
            left += n;
        }
        return nums;
    }
}
