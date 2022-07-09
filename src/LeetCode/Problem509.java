package LeetCode;

import java.util.HashMap;

public class Problem509 {
    //https://leetcode.com/problems/fibonacci-number/
    public static void main(String[] args) {

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
