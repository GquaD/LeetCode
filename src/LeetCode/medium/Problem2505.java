package LeetCode.medium;

public class Problem2505 {
    //https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/bitwise-or-of-all-subsequence-sums/solutions/5985956/java-100-faster-one-pass-solution/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //54.50
    //MB
    //Beats
    //100.00%
    public long subsequenceSumOr(int[] nums) {
        long or = 0, sum = 0;
        for (int n : nums) {
            sum += n;
            or |= n;
            or |= sum;
        }
        return or;
    }
}
