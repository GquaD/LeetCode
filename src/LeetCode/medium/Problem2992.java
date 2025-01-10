package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2992 {
    //https://leetcode.com/problems/number-of-self-divisible-permutations/
    public static void main(String[] args) {

    }

    //
    //10-15min
    //Runtime
    //435
    //ms
    //Beats
    //10.81%
    //Analyze Complexity
    //Memory
    //44.55
    //MB
    //Beats
    //5.41%
    public int selfDivisiblePermutationCount(int n) {
        int[] res = new int[1];

        Set<Integer> set = new HashSet<>();
        recCalc(1, n, res, set);
        return res[0];
    }

    private void recCalc(int idx, int end, int[] res, Set<Integer> set) {
        if (idx > end) {
            res[0]++;
            return;
        }

        for (int i = 1; i <= end; i++) {
            if (!set.contains(i) && gcd(idx, i) == 1) {
                set.add(i);
                recCalc(idx + 1, end, res, set);
                set.remove(i);
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
