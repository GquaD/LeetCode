package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem204 {
    //https://leetcode.com/problems/count-primes/
    public static void main(String[] args) {
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(6));
        System.out.println(countPrimes(10));
    }

    //nnnn
    //Runtime
    //114 ms
    //Beats
    //90.37%
    //Memory
    //46.8 MB
    //Beats
    //75.33%
    static int countPrimes(int n) {
        if (n <= 1) return 0;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) count++;
        }
        return Math.max(0, count - 1);
    }


    /*static Map<Integer, Integer> map;
    static int[] cache;
    static {
        //fillTheMap();
        fillTheCache();
    }

    private static void fillTheCache() {
        int size = 5_000_000;
        cache = new int[size + 1];
        int count = 0;
        for (int i = 0; i <= size; i++) {
            if (isPrime(i)) cache[i] = count++;
            else cache[i] = count;
        }
    }

    private static void fillTheMap() {
        map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= 5_000_000; i++) {
            if (isPrime(i)) map.put(i, count++);
            else map.put(i, count);
        }
    }

    static int countPrimes1(int n) {
        //return map.get(n);
        return cache[n];
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        int grow = 2;
        int sqrt = (int) Math.sqrt(n);
        while (grow <= sqrt) {
            if (n % grow++ == 0) {
                return false;
            }
        }
        return true;
    }*/
}
