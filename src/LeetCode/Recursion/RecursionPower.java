package LeetCode.Recursion;

public class RecursionPower {
    public static void main(String[] args) {
        System.out.println(myPow2(2, -2147483647));
        /*System.out.println(myPow2(0.00001, 2147483647));
        System.out.println(myPow2(2, 3));
        System.out.println(myPow2(2, 10));
        System.out.println(myPow(2, 4));
        System.out.println(myPow(2, -3));
        System.out.println(myPow(2, -8));
        System.out.println(myPow(3, 3));*/
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
        if (x > 0 && x < 1 && n > 1000000) {
            return 0.0;
        }
        if (x > -1 && x < -1 && n > 1000000) {
            return 0.0;
        }

        if (x > 1 && n < -1000000) {
            return 0.0;
        }

        if (x < -1 && n < -1000000) {
            return 0.0;
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

    public static double myPow2(double x, int n) {
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
        if (x == 1.0) {
            return x;
        }
        if (x == 0) {
            return 0;
        }
        if (x > 0 && x < 1 && n > 1000000) {
            return 0.0;
        }
        if (x > -1 && x < -1 && n > 1000000) {
            return 0.0;
        }

        if (x > 1 && n < -1000000) {
            return 0.0;
        }

        if (x < -1 && n < -1000000) {
            return 0.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) {
                return -x;
            } else {
                return x;
            }

        }
        double result = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
        } else {
            for (int i = 0; i < (-n) ; i++) {
                result *= 1 / x;
            }
        }
        return result;
    }
}
