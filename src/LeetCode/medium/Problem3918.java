package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3918 {
    //15min

    //Runtime
    //2
    //ms
    //Beats
    //99.17%
    //Memory
    //42.62
    //MB
    //Beats
    //66.10%
    //https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/solutions/8155046/java-fast-and-furious-solution-by-tbekpr-nrw2/
    private static List<Integer> primes = calculatePrimes();

    public int sumOfPrimesInRange(int n) {
        int rev = revert(n), min = Math.min(n, rev), max = Math.max(n, rev);
        int sum = 0;
        for (int p: primes) {
            if (p <= max && p >= min) sum += p;
            else if (p > max) break;
        }

        return sum;
    }

    private int revert(int n) {
        int res = 0;
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    private static List<Integer> calculatePrimes() {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) list.add(i);
        }
        return list;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;

        int sqrt = (int) (Math.sqrt(n) + 1);

        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
