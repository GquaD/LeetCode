package LeetCode.medium;

public class Problem2110 {
    //https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/solutions/4506056/java-o-n-1-run-solution/
    //11min
    //Runtime
    //2 ms
    //Beats
    //99.45%
    //Memory
    //59.1 MB
    //Beats
    //33.15%
    static long getDescentPeriods1(int[] prices) {
        int prev = prices[0], count = 1, all = prices.length;
        long res = all;
        for (int i = 0; i < prices.length; i++) {
            if (prev - prices[i] == 1) {
                count++;
            } else {
                res += ((count * (count - 1L)) / 2);
                count = 1;
            }
            prev = prices[i];
        }
        if (count > 1) res += ((count * (count - 1L)) / 2L);
        return res;
    }
}
