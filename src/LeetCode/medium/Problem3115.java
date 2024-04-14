package LeetCode.medium;

import java.util.*;

public class Problem3115 {
    //https://leetcode.com/problems/maximum-prime-difference/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/maximum-prime-difference/solutions/5022471/java-o-n-using-hashset/
    //1min
    //Runtime
    //18
    //ms
    //Beats
    //66.67%
    //of users with Java
    //Memory
    //79.82
    //MB
    //Beats
    //100.00%
    //of users with Java

    static Set<Integer> set;

    public int maximumPrimeDifference(int[] nums) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return last - first;
    }

    private boolean isPrime(int n) {
        if (set == null) {
            set = new HashSet<>();
            for (int i = 2; i <= 100; i++) {
                int count = 0;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) count++;
                }
                if (count == 0) set.add(i);
            }
        }
        return set.contains(n);
    }


    //5min
    //Runtime
    //51
    //ms
    //Beats
    //16.67%
    //of users with Java
    //Memory
    //78.85
    //MB
    //Beats
    //100.00%
    //of users with Java
    static List<Integer> list;

    public int maximumPrimeDifference1(int[] nums) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime1(nums[i])) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return last - first;
    }

    private boolean isPrime1(int n) {
        if (list == null) {
            list = new ArrayList<>();
            for (int i = 2; i <= 100; i++) {
                int count = 0;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) count++;
                }
                if (count == 0) list.add(i);
            }
        }
        return Collections.binarySearch(list, n) >= 0;
    }
}
