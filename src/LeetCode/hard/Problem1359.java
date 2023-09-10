package LeetCode.hard;

public class Problem1359 {
    //https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
    public static void main(String[] args) {
        System.out.println(countOrders(1));
        System.out.println(countOrders(2));
        System.out.println(countOrders(3));
        System.out.println(countOrders(4));
        System.out.println(countOrders(5));
        System.out.println(countOrders(6));
        System.out.println(countOrders(7));
        System.out.println(countOrders(8));
    }

    //https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/solutions/4027504/java-0ms-100-faster-math/
    //15-20min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.7 MB
    //Beats
    //46.34%
    //formula I found is: (n * (2n - 1)! ) / 2 ^ (n - 1)
    //the only problem is to deal with modulo of 10^9 + 7
    static int countOrders(int n) {
        int factorial = 2 * n - 1, pow2 = n - 1, mod = 1_000_000_007;
        long res = n;
        for (int i = 1; i <= factorial; i++) {
            res *= i;
            while (pow2 > 0 && res % 2 == 0) {
                res /= 2;
                pow2--;
            }
            res %= mod;
        }
        return (int) res;
    }
}
