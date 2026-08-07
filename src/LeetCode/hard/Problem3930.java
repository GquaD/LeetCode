package LeetCode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem3930 {
    //15min

    // similar to https://leetcode.com/problems/power-update-after-k-th-largest-insertion-i/submissions/
    //Runtime
    //391
    //ms
    //Beats
    //25.00%
    //Memory
    //89.20
    //MB
    //Beats
    //100.00%
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        List<Integer> sortedList = new ArrayList<>();
        Arrays.sort(nums);
        for (int n: nums) sortedList.add(n);
        long result = p;

        List<Integer> list = new ArrayList<>();
        for (int[] q: queries) {
            int val = q[0], k = q[1], x = getKth(val, k, sortedList);
            result = modPow(result, x);
            list.add((int) result);
        }

        return list;
    }

    private int getKth(int val, int k, List<Integer> list) {
        int idx = Collections.binarySearch(list, val);
        if (idx < 0) idx = -idx - 1;
        list.add(idx, val);


        return list.get(list.size() - k);
    }

    private long modPow(long p, long pow) {
        long mod = 1_000_000_007L, result = 1;

        p %= mod;

        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = (result * p) % mod;
            }

            p = (p * p) % mod;
            pow >>= 1;
        }

        return result;
    }
}
