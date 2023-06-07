package LeetCode.easy;

public class Problem2706 {
    //https://leetcode.com/problems/buy-two-chocolates/
    public static void main(String[] args) {
        System.out.println(buyChocolates(new int[]{1,2,2}, 3));
        System.out.println(buyChocolates(new int[]{3,2,3}, 3));
        System.out.println(buyChocolates(new int[]{3,2,1}, 2));
    }

    //https://leetcode.com/problems/buy-two-chocolates/solutions/3609927/java-o-n-100-faster-solution/
    //5 min
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //43.9 MB
    //Beats
    //10.48%
    static int buyChocolates(int[] prices, int money) {
        int min = 101, min2 = 101;
        for (int p : prices) {
            if (min > p) {
                min2 = min;
                min = p;
                continue;
            }
            if (min <= p && min2 > p) min2 = p;
        }
        return min + min2 > money ? money : money - min - min2;
    }
}
