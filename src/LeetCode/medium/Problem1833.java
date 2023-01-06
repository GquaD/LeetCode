package LeetCode.medium;

import java.util.Arrays;

public class Problem1833 {
    //https://leetcode.com/problems/maximum-ice-cream-bars/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-ice-cream-bars/solutions/3006223/java-96-faster-short-solution/
    //5 min
    //Runtime
    //37 ms
    //Beats
    //95.50%
    //Memory
    //56.6 MB
    //Beats
    //68.72%
    static int maxIceCream(int[] costs, int coins) {
        if (costs.length > 1) Arrays.sort(costs);
        int count = 0;
        for (int n : costs) {
            if (coins < n) return count;
            else coins -= n;
            count++;
        }
        return costs.length;
    }
}
