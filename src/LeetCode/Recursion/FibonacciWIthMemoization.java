package LeetCode.Recursion;

import java.util.HashMap;

public class FibonacciWIthMemoization {
    public static void main(String[] args) {
        System.out.println("fib for 0 = " + fib(0));
        System.out.println("fib for 1 = " + fib(1));
        System.out.println("fib for 2 = " + fib(2));
        System.out.println("fib for 3 = " + fib(3));
        System.out.println("fib for 4 = " + fib(4));
        System.out.println("fib for 5 = " + fib(5));
        System.out.println("fib for 6 = " + fib(6));
        System.out.println("fib for 7 = " + fib(7));
        System.out.println("fib for 8 = " + fib(8));
        System.out.println("fib for 9 = " + fib(9));
        System.out.println("fib for 10 = " + fib(10));
    }

    static HashMap<Integer, Integer> cache = new HashMap<>();

    static int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n < 2) {
            return n;
        }
        int result = fib(n - 2) + fib(n - 1);
        if (!cache.containsKey(n)) {
            cache.put(n, result);
        }
        return result;
    }
}
