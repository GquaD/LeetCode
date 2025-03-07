package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2523 {
    //https://leetcode.com/problems/closest-prime-numbers-in-range
    public static void main(String[] args) {

    }


    //2min
    //Runtime
    //336
    //ms
    //Beats
    //15.87%
    //Analyze Complexity
    //Memory
    //56.26
    //MB
    //Beats
    //10.32%
    //class Solution {
    //
    //    private static Set<Integer> primes;
    //
    //    public int[] closestPrimes(int left, int right) {
    //        if (primes == null) {
    //            primes = new HashSet<>();
    //            for (int i = 2; i <= 1_000_000; i++) {
    //                if (isPrime(i)) primes.add(i);
    //            }
    //        }
    //
    //        List<Integer> list = new ArrayList<>();
    //        for (int i = left; i <= right; i++) {
    //            if (primes.contains(i)) {
    //                list.add(i);
    //            }
    //        }
    //        if (list.size() < 2) return new int[]{-1, -1};
    //        int min = Integer.MAX_VALUE, res[] = new int[]{-1, -1};
    //        for (int i = 1; i < list.size(); i++) {
    //            int a = list.get(i - 1), b = list.get(i);
    //            if (b - a < min) {
    //                min = b - a;
    //                res[0] = a;
    //                res[1] = b;
    //            }
    //        }
    //        return res;
    //    }
    //
    //    private boolean isPrime(int n) {
    //        if (n == 1) return false;
    //        for (int i = 2; i <= Math.sqrt(n); i++) {
    //            if (n % i == 0) return false;
    //        }
    //        return true;
    //    }
    //}

    //https://leetcode.com/problems/closest-prime-numbers-in-range/solutions/6509267/java-straightforward-solution/
    //10min
    //Runtime
    //1650
    //ms
    //Beats
    //5.20%
    //Analyze Complexity
    //Memory
    //45.49
    //MB
    //Beats
    //54.80%
    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        if (list.size() < 2) return new int[]{-1, -1};
        int min = Integer.MAX_VALUE, res[] = new int[]{-1, -1};
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1), b = list.get(i);
            if (b - a < min) {
                min = b - a;
                res[0] = a;
                res[1] = b;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
