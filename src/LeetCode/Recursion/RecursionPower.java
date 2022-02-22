package LeetCode.Recursion;

public class RecursionPower {
    public static void main(String[] args) {
        System.out.println(myPow(2, -3));
    }
    static double initial = 2;
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n > 0) {
            return myPow(x * initial, n - 1);
        } else {
            return myPow(1 / initial, n + 1);
        }
    }
}
