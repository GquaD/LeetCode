package LeetCode.easy;

public class Problem3550 {
    //https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
    public static void main(String[] args) {

    }

    //http://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/solutions/6763173/java-1ms-solution-by-tbekpro-o9ci/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.03
    //MB
    //Beats
    //98.26%
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sumDigits(nums[i]) == i) return i;
        }
        return -1;
    }

    private int sumDigits(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
