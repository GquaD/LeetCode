package LeetCode.easy;

import java.util.Arrays;

public class Problem2144 {
    //2min

    //Runtime
    //6
    //ms
    //Beats
    //40.64%
    //Memory
    //44.52
    //MB
    //Beats
    //55.06%
    public int minimumCost(int[] cost) {
        int sum = 0;
        Arrays.sort(cost);
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            if (i >= 1) sum += cost[i] + cost[i - 1];
            else if (i == 0) sum += cost[i];
        }
        return sum;
    }
}
