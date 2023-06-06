package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1414 {
    //https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
        System.out.println(findMinFibonacciNumbers(8));
    }

    //https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/solutions/3605996/java-greedy-fib-method-using-memoization/
    //30 min
    //Runtime
    //2 ms
    //Beats
    //69.92%
    //Memory
    //39.2 MB
    //Beats
    //99.25%
    static List<Integer> list;
    static int findMinFibonacciNumbers(int k) {
        if (k == 1) return 1;
        if (k == 2) return 1;
        if (list == null) fillListWithFib();

        int tempK = k, count = 0, idx = Collections.binarySearch(list, k);
        if (idx >= 0) return 1;
        else idx = Math.min(-idx - 1, list.size() - 1);
        while (tempK > 0) {
            if (tempK - list.get(idx) >= 0) {
                count++;
                tempK -= list.get(idx);
            } else {
                idx--;
            }
        }
        return count;
    }

    private static void fillListWithFib() {
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        fib(1, 1);
    }
    static void fib(int prev1, int prev2) {
        if (!list.isEmpty() && list.get(list.size() - 1) >= 1_000_000_000) {
            return;
        }

        int next = prev1 + prev2;
        if (Collections.binarySearch(list, next) >= 0) return;
        list.add(next);
        fib(prev2, next);
    }
}
