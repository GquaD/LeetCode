package LeetCode.easy;

public class Problem3936 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //99.68%
    //Memory
    //46.37
    //MB
    //Beats
    //78.68%
    public int minimumSwaps(int[] nums) {
        int count0 = 0;
        for (int n: nums) if (n == 0) count0++;
        int result = count0;
        for (int i = nums.length - 1; i >= nums.length - count0; i--)
            if (nums[i] == 0)
                result--;
        return result;
    }
}
