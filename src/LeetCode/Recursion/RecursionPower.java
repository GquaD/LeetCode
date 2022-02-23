package LeetCode.Recursion;

public class RecursionPower {
    public static void main(String[] args) {
        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2, 3));
        System.out.println(myPow(2, 4));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(2, -8));
        System.out.println(myPow(3, 3));
    }
    static double initial = 0;

    public static double myPow(double x, int n) {
        initial = x;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n < -1) {
            x *= 1 / initial;
        }
        return myPowHelper(x, n);
    }

    public static double myPowHelper(double x, int n) {
        if (n == 0) {
            return x;
        }
        if (n == 1) {
            return x;
        }
        if (n > 0) {
            return myPowHelper(x * initial, n - 1);
        } else {
            return myPowHelper((x * (1 / initial)), n + 1);
        }
    }
}
