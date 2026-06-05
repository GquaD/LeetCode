package LeetCode.easy;

public class Problem3411 {
    //10min

    //Runtime
    //48
    //ms
    //Beats
    //11.79%
    //Memory
    //44.32
    //MB
    //Beats
    //27.83%
    public int maxLength(int[] nums) {
        int maxlen = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i], gcd = nums[i], lcm = nums[i];
                for (int k = i; k < j; k++) {
                    prod *= nums[k + 1];
                    gcd = gcd(gcd, nums[k + 1]);
                    lcm = lcm(lcm, nums[k + 1]);
                }
                if (prod == gcd * lcm)
                    maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
