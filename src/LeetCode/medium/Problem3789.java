package LeetCode.medium;

public class Problem3789 {
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //41.18%
    //Memory
    //42.51
    //MB
    //Beats
    //50.00%
    //https://leetcode.com/problems/minimum-cost-to-acquire-required-items/solutions/8609428/java-o1-solution-by-tbekpro-rxa9/
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long one = 0, two = 0, three = 0, four = 0;

        if (need1 < need2) {
            int temp = need1;
            need1 = need2;
            need2 = temp;

            temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }

        one = need1 * 1L * cost1 + need2 * 1L * cost2;

        two = 1L * costBoth * need1;

        three = Math.max(0L, costBoth * 1L * need2 + 1L * (Math.max(0L, need1 - need2)) * cost1);

        four = Math.max(0L, costBoth * 1L * (Math.max(0L, need2 - 1)) + 1L * cost2 + 1L * (Math.max(0L, need1 - need2 + 1)) * cost1);

        return Math.min(Math.min(one, two), Math.min(three, four));
    }
}
