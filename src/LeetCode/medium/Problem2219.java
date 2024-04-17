package LeetCode.medium;

public class Problem2219 {
    //https://leetcode.com/problems/maximum-sum-score-of-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-sum-score-of-array/solutions/5036438/java-o-n-100-faster-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //56.48
    //MB
    //Beats
    //55.10%
    //of users with Java
    static long maximumSumScore(int[] nums) {
        long sum = 0, max = Long.MIN_VALUE, left = 0;
        for (int n : nums) sum += n;
        for (int n : nums) {
            left += n;
            max = Math.max(left, Math.max(max, sum));
            sum -= n;
        }
        return max;
    }
}
