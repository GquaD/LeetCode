package LeetCode.medium;

public class Problem4044 {
    //15min

    //Runtime
    //5
    //ms
    //Beats
    //100.00%
    //Memory
    //71.42
    //MB
    //Beats
    //100.00%
    public int countGoodRotations(int[] nums) {
        long l = 0, r = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                l += nums[i];
            } else {
                r += nums[i];
            }
        }

        if (l - r > 0) count++;
        for (int i = 1; i < nums.length; i++) {
            l -= nums[i - 1];
            l += nums[(nums.length / 2 - 1 + i) % nums.length];
            r -= nums[(nums.length / 2 - 1 + i) % nums.length];
            r += nums[i - 1];

            if (l - r > 0) count++;
        }

        return count;
    }

}
