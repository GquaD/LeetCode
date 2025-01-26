package LeetCode.easy;

public class Problem3432 {
    //https://leetcode.com/problems/count-partitions-with-even-sum-difference
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-partitions-with-even-sum-difference/solutions/6332064/java-suffix-sum-solution-by-tbekpro-dqks/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //41.84
    //MB
    //Beats
    //-%
    public int countPartitions(int[] nums) {
        int len = nums.length, suffix[] = new int[len], prev = 0;
        for (int i = len - 1; i >= 0; i--) {
            suffix[i] = prev + nums[i];
            prev = suffix[i];
        }
        int sum = 0, res = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += nums[i];
            if ((sum - suffix[i + 1]) % 2 == 0) res++;
        }
        return res;
    }
}
