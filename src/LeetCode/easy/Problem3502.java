package LeetCode.easy;

public class Problem3502 {
    //https://leetcode.com/problems/minimum-cost-to-reach-every-position/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-cost-to-reach-every-position/solutions/6597006/java-running-minimum-solution-by-tbekpro-y1nf/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //97.67%
    //Analyze Complexity
    //Memory
    //69.82%
    public int[] minCosts(int[] cost) {
        int min = cost[0];
        for (int i = 1; i < cost.length; i++) {
            min = Math.min(min, cost[i]);
            cost[i] = min;
        }
        return cost;
    }
}
