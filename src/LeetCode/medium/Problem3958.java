package LeetCode.medium;

public class Problem3958 {
    //2min

    //Runtime
    //2
    //ms
    //Beats
    //-%
    //Memory
    //44.09
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/minimum-cost-to-split-into-ones-ii/solutions/8325902/java-o1-solution-by-tbekpro-05jj/
    public long minCost(int n) {
        return n * (n - 1L) / 2L;
    }
}
