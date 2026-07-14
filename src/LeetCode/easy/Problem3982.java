package LeetCode.easy;

public class Problem3982 {
    //3-5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //45.18
    //MB
    //Beats
    //82.27%
    //https://leetcode.com/problems/sum-of-integers-with-maximum-digit-range/solutions/8380949/java-100-fast-solution-by-tbekpro-5q74/
    public int maxDigitRange(int[] nums) {
        int sum = 0, max = 0;
        for (int n: nums) {
            int range = digitRange(n);
            if (max < range) {
                sum = n;
                max = range;
            } else if (max == range) {
                sum += n;
            }
        }
        return sum;
    }

    private int digitRange(int n) {
        int min = 9, max = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            min = Math.min(min, d);
            max = Math.max(max, d);
        }
        return max - min;
    }
}
