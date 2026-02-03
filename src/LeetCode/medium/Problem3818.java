package LeetCode.medium;

public class Problem3818 {
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //99.41%
    //Analyze Complexity
    //Memory
    //120.22
    //MB
    //Beats
    //58.41%
    public int minimumPrefixLength(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1]) return i;
        }
        return 0;
    }
}
