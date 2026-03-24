package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2614 {
    //10min

    //Runtime
    //3
    //ms
    //Beats
    //83.22%
    //Memory
    //82.32
    //MB
    //Beats
    //84.01%
    private static Set<Integer> primes = new HashSet<>();

    public int diagonalPrime(int[][] nums) {
        int max = 0, rows = nums.length;
        for (int i = 0; i < rows; i++) {
            if (isPrime(nums[i][i])) {
                max = Math.max(max, nums[i][i]);
            }
        }

        for (int i = 0; i < rows; i++) {
            int idx = rows - i - 1;
            if (isPrime(nums[idx][i])) {
                max = Math.max(max, nums[idx][i]);
            }
        }

        return max;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (primes.contains(n)) return true;

        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }

        primes.add(n);
        return true;
    }
}
