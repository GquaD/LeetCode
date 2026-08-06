package LeetCode.easy;

public class Problem4010 {
    //5min

    //Runtime
    //1026
    //ms
    //Beats
    //18.72%
    //Memory
    //46.83
    //MB
    //Beats
    //78.46%
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int gcd = gcd(nums[i], nums[j]);
                max = Math.max(max, nums[i] * 1L * nums[j] / (gcd * gcd));
            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
