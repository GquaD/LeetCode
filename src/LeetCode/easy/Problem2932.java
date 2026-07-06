package LeetCode.easy;

public class Problem2932 {
    //5min

    //Runtime
    //2
    //ms
    //Beats
    //98.55%
    //Memory
    //44.39
    //MB
    //Beats
    //98.76%
    public int maximumStrongPairXor(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i; j < nums.length; j++) {
                int m = nums[j];
                if (Math.abs(n - m) > Math.min(n, m)) continue;
                xor = Math.max(xor, n ^ m);
            }
        }

        return xor;
    }
}
