package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2601 {
    //https://leetcode.com/problems/prime-subtraction-operation/
    public static void main(String[] args) {
        System.out.println(primeSubOperation(new int[]{18,12,14,6}));
        System.out.println(primeSubOperation(new int[]{998,2}));
        System.out.println(primeSubOperation(new int[]{2,2}));
        System.out.println(primeSubOperation(new int[]{4,9,6,10}));
        System.out.println(primeSubOperation(new int[]{6,8,11,12}));
        System.out.println(primeSubOperation(new int[]{5,8,3}));
    }


    //https://leetcode.com/problems/prime-subtraction-operation/solutions/3358259/java-o-n-logk-solution/
    //1 hour
    //Runtime
    //2 ms
    //Beats
    //95.83%
    //Memory
    //42.8 MB
    //Beats
    //56.48%
    static List<Integer> listPrimes;
    static boolean primeSubOperation(int[] nums) {
        if (nums.length == 1) return true;
        if (listPrimes == null) fillWithPrimes();
        int prev = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int curr = nums[i];
            if (curr < prev) {
                prev = curr;
            } else {
                int diff = curr - prev + 1;
                int idx = Collections.binarySearch(listPrimes, diff);
                if (idx < 0) idx = -idx - 1;
                idx = Math.min(idx, listPrimes.size() - 1);
                if (listPrimes.get(idx) < diff) idx = Math.min(idx + 1, listPrimes.size() - 1);
                int res = curr - listPrimes.get(idx);
                if (res <= 0) return false;
                if (res >= prev) return false;
                else prev = res;
            }
        }
        return true;
    }

    private static void fillWithPrimes() {
        listPrimes = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            int root = (int) Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 2; j <= root; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) listPrimes.add(i);
        }
    }
    //int prev = -1;
    //        for (int i = 0; i < nums.length; i++) {
    //            int curr = nums[i];
    //            int idx = Collections.binarySearch(listPrimes, curr);
    //            if (idx < 0) {
    //                idx = -idx - 2;
    //                int diff = curr - listPrimes.get(idx);
    //                if (diff > prev) {
    //                    prev = diff;
    //                } else {
    //                    return false;
    //                }
    //            } else {
    //                int idx1 = Math.max(idx - 1, 0), idx2 = idx;
    //                int diff1 = curr - listPrimes.get(idx1), diff2 = curr - listPrimes.get(idx2);
    //                if (diff2 > prev) {
    //                    prev = diff2;
    //                } else if (diff1 > prev) {
    //                    prev = diff1;
    //                } else {
    //                    return false;
    //                }
    //            }
    //        }
}
