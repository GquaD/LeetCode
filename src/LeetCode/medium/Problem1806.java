package LeetCode.medium;

import java.util.Arrays;

public class Problem1806 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(2));
        System.out.println(reinitializePermutation(4));
        System.out.println(reinitializePermutation(6));
        System.out.println(reinitializePermutation(8));
        System.out.println(reinitializePermutation(10));
        System.out.println(reinitializePermutation(12));
        System.out.println(reinitializePermutation(14));
        System.out.println(reinitializePermutation(16));
        System.out.println(reinitializePermutation(18));
        System.out.println(reinitializePermutation(20));
        System.out.println(reinitializePermutation(32));
        System.out.println(reinitializePermutation(998));
    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/solutions/3476267/java-straightforward-solution/
    //Runtime
    //21 ms
    //Beats
    //50.68%
    //Memory
    //39.8 MB
    //Beats
    //58.90%
    static int reinitializePermutation(int n) {
        int temp = n, pow = 0;
        while (temp % 2 == 0) {
            temp /= 2;
            pow++;
        }
        if (temp == 1) return pow;
        int[] perm = new int[n], arr = new int[n], init = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            init[i] = i;
        }
        int count = 0;
        do {
            for (int i = 0; i < perm.length; i+=2) arr[i] = perm[i / 2];
            for (int i = 1; i < perm.length; i+=2) arr[i] = perm[n / 2 + (i - 1) / 2];
            int[] arrTemp = perm;
            perm = arr;
            arr = arrTemp;
            Arrays.fill(arr, 0);
            count++;
        } while (!areEqual(perm, init));
        return count;
    }

    private static boolean areEqual(int[] perm, int[] init) {
        for (int i = 0; i < perm.length; i++) if (perm[i] != init[i]) return false;
        return true;
    }
}
