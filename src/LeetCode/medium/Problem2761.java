package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2761 {
    //https://leetcode.com/problems/prime-pairs-with-target-sum/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(findPrimePairs(10));
        LeetCodeUtils.printListWithListsOfIntegers(findPrimePairs(2));
        LeetCodeUtils.printListWithListsOfIntegers(findPrimePairs(1000));
    }

    //seen generatePrimes() from https://leetcode.com/problems/count-primes/description/ solution
    //30 min
    //Runtime
    //56 ms
    //Beats
    //99.29%
    //Memory
    //55.2 MB
    //Beats
    //18.15%
    static Set<Integer> listPrime;
    static List<List<Integer>> findPrimePairs(int n) {
        if (listPrime == null) generatePrimes(1_000_001);
        List<List<Integer>> list = new ArrayList<>();
        for (int k : listPrime) {
            if (k <= n / 2) {
                if (listPrime.contains(n - k)) list.add(Arrays.asList(k, n - k));
            } else break;
        }
        return list;
    }

    private static void generatePrimes(int n) {
        listPrime = new LinkedHashSet<>();
        if (n <= 1) return;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) listPrime.add(i);
        }
    }

    private static void generatePrimeNumbers() {
        listPrime = new LinkedHashSet<>();
        for (int i = 2; i < 1_000_000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) if (i % j == 0) isPrime = false;
            if (isPrime) listPrime.add(i);
        }
    }
}
