package LeetCode.easy;

public class Problem3353 {
    //https://leetcode.com/problems/minimum-total-operations/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-total-operations/solutions/6055437/java-one-pass-solution/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //66.67%
    //Analyze Complexity
    //Memory
    //58.11
    //MB
    //Beats
    //44.44%
    public int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) if (nums[i] != nums[i + 1]) count++;
        return count;
    }
}
