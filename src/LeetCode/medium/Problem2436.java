package LeetCode.medium;

public class Problem2436 {
    //https://leetcode.com/problems/minimum-split-into-subarrays-with-gcd-greater-than-one
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-split-into-subarrays-with-gcd-greater-than-one/solutions/6139281/java-o-nlogn-solution/
    //20min
    //Runtime
    //1
    //ms
    //Beats
    //85.71%
    //Analyze Complexity
    //Memory
    //42.52
    //MB
    //Beats
    //12.50%
    public int minimumSplits(int[] nums) {
        int sub = 1, gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            gcd = gcd(gcd, a);
            if (gcd == 1) {
                sub++;
                gcd = nums[i];
            }
        }
        return sub;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
