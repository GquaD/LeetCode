package LeetCode.easy;

import java.util.*;

public class Problem2815 {
    //https://leetcode.com/problems/max-pair-sum-in-an-array/
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{31,25,72,79,74}));
        System.out.println(maxSum(new int[]{1,2,3,4}));
        System.out.println(maxSum(new int[]{51,71,17,24,42}));
    }

    //https://leetcode.com/problems/max-pair-sum-in-an-array/solutions/3918143/java-treemap-of-priorityqueues/
    //15 min
    //Runtime
    //11 ms
    //Beats
    //61.3%
    //Memory
    //43.8 MB
    //Beats
    //56%
    static int maxSum(int[] nums) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int n : nums) {
            int maxDig = findMaxDigit(n);
            map.putIfAbsent(maxDig, new PriorityQueue<>(Comparator.reverseOrder()));
            map.get(maxDig).offer(n);
        }

        int max = -1;
        for (int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            if (pq.size() > 1) {
                max = Math.max(pq.poll() + pq.poll(), max);
            }
        }
        return max;
    }

    static int findMaxDigit(int n) {
        int max = 0;
        while (n > 0) {
            max = Math.max(max, n % 10);
            n /= 10;
        }
        return max;
    }
}
