package LeetCode.medium;

import java.util.TreeSet;

public class Problem3896 {
    //20min

    //Runtime
    //159
    //ms
    //Beats
    //80.11%
    //Memory
    //93.66
    //MB
    //Beats
    //24.94%
    //https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/solutions/7996759/java-solution-by-tbekpro-wvdv/

    private static TreeSet<Integer> set = generatePrimes();

    private static TreeSet<Integer> generatePrimes() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        for (int i = 3; i <= 100_000; i++) {
            if (isPrime(i)) {
                set.add(i);
            }
        }
        set.add(100_003);
        return set;
    }

    private static boolean isPrime(int n) {
        int root = (int) (Math.sqrt(n) + 1);

        for (int i = 2; i <= root; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i % 2 == 0) {
                if (!set.contains(n)) {
                    Integer high = set.higher(n);
                    count += high - n;
                }
            } else {
                if (set.contains(n)) {
                    if (set.contains(n + 1)) {
                        count+=2;
                    } else {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
