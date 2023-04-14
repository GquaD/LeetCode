package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2521 {
    //https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/
    public static void main(String[] args) {
        System.out.println(distinctPrimeFactors(new int[]{2,4,3,7,10,6}));
        System.out.println(distinctPrimeFactors(new int[]{2,4,8,16}));
    }

    //https://leetcode.com/problems/distinct-prime-factors-of-product-of-array/solutions/3415630/java-using-set-o-n-k/
    //10 min
    //Runtime
    //80 ms
    //Beats
    //51.12%
    //Memory
    //43.5 MB
    //Beats
    //53.35%
    static int distinctPrimeFactors(int[] nums) {
        Set<Integer> setPrimes = new HashSet<>();
        for (int n : nums) {
            int temp = n, start = 2;
            while (temp > 1) {
                if (temp % start == 0) {
                    temp /= start;
                    setPrimes.add(start);
                } else {
                    start++;
                }
            }
        }
        return setPrimes.size();
    }
}
