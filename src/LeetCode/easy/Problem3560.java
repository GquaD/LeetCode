package LeetCode.easy;

public class Problem3560 {
    //https://leetcode.com/problems/find-minimum-log-transportation-cost
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-minimum-log-transportation-cost/solutions/6789726/java-2-line-100-faster-solution-by-tbekp-7koe/
    //10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.92
    //MB
    //Beats
    //63.55%
    public long minCuttingCost(int n, int m, int k) {
        int max = Math.max(m, n);
        return max <= k ? 0 : 1L * k * (max - k);
    }
}
