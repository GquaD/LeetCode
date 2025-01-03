package LeetCode.medium;

public class Problem2270 {
    //https://leetcode.com/problems/number-of-ways-to-split-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-ways-to-split-array/solutions/6224748/java-prefix-sum-solution-by-tbekpro-7db7/
    //5min
    //Runtime
    //3
    //ms
    //Beats
    //59.69%
    //Analyze Complexity
    //Memory
    //61.46
    //MB
    //Beats
    //7.38%
    public int waysToSplitArray(int[] nums) {
        int n = nums.length, res = 0;
        long left = 0, s = 0;
        long[] sum = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            s += nums[i];
            sum[i] = s;
        }

        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            if (left >= sum[i + 1])
                res++;
        }
        return res;
    }
}
