package LeetCode.medium;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem2462 {
    //https://leetcode.com/problems/total-cost-to-hire-k-workers/
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{31}, 1, 1));
        System.out.println(totalCost(new int[]{31,2, 6}, 1, 1));
        System.out.println(totalCost(new int[]{31,2, 6}, 2, 1));
        System.out.println(totalCost(new int[]{31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2));
        System.out.println(totalCost(new int[]{18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75}, 13, 23));
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 3));
        System.out.println(totalCost(new int[]{1, 2, 4, 1}, 3, 3));
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
    }

    //nnnn
    //Runtime
    //64 ms
    //Beats
    //64.53%
    //Memory
    //57.6 MB
    //Beats
    //41.86%
    static long totalCost(int[] costs, int k, int n) {
        int l = 0, r = costs.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        long sum = 0;
        while (pq.size() < n && l <= r) pq.offer(costs[l++]);
        while (pq2.size() < n && l <= r) pq2.offer(costs[r--]);

        while (k-- > 0) {
            if (pq.size() < n && l <= r) pq.offer(costs[l++]);
            if (pq2.size() < n && l <= r) pq2.offer(costs[r--]);
            int t1 = pq.size() > 0 ? pq.peek() : Integer.MAX_VALUE, t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                sum += t1;
                pq.poll();
            } else {
                sum += t2;
                pq2.poll();
            }
        }
        return sum;
    }

    //Wrong Answer
    //
    //159 / 160 testcases passed
    static long totalCost4(int[] costs, int k, int n) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() == b.getKey() ? a.getValue() - b.getValue() : a.getKey() - b.getKey());
        for (int i = 0; i < n; i++) {
            visited.add(i);
            pq.offer(new Pair<>(costs[i], i));
        }

        for (int i = 0; i < n ; i++) {
            int idx = costs.length - 1 - i;
            if (visited.add(idx)) {
                pq.offer(new Pair<>(costs[idx], idx));
            }
        }
        long sum = 0;
        int count = 0, half = costs.length / 2, l = n, r = costs.length - 1 - n;
        while (count++ < k) {
            Pair<Integer, Integer> p = pq.poll();
            sum += p == null ? 0 : p.getKey();
            if (p.getValue() < half) {
                if (l < costs.length && visited.add(l)) {
                    pq.offer(new Pair<>(costs[l], l++));
                }
            } else {
                if (r >= 0 && visited.add(r)) {
                    pq.offer(new Pair<>(costs[r], r--));
                }
            }
        }
        return sum;
    }

    static long totalCost3(int[] costs, int k, int n) {
        long sum = 0;
        if (costs.length == 1) return costs[0];
        if (costs.length / 2 < k) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) sum += costs[i];
            return sum;
        }
        if (costs.length % 2 == 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
            int half = costs.length / 2;
            for (int i = 0; i < Math.min(half, n); i++) {
                pq.offer(costs[i]);
                pq2.offer(costs[costs.length - 1 - i]);
            }
            int count = 0, c = Math.min(half, n), c2 = costs.length - c - 1;
            while (count++ < k) {
                int a = pq.peek() == null ? Integer.MAX_VALUE : pq.peek(), b = pq2.peek() == null ? Integer.MAX_VALUE : pq2.peek();
                if (a <= b) {
                    sum += pq.peek() == null ? 0 : pq.poll();
                    if (c < half) pq.offer(costs[c++]);
                } else {
                    sum += pq2.poll();
                    if (c2 >= half) pq2.offer(costs[c2--]);
                }
            }
        } else {
            PriorityQueue<Integer> pq = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
            int half = costs.length / 2;
            for (int i = 0; i < Math.min(half, n); i++) {
                pq.offer(costs[i]);
                pq2.offer(costs[costs.length - 1 - i]);
            }
            int count = 0, c = Math.min(half, n), c2 = costs.length - c - 1;
            boolean halfUsed = false;
            while (count++ < k) {
                int a = pq.peek() == null ? Integer.MAX_VALUE : pq.peek(), b = pq2.peek() == null ? Integer.MAX_VALUE : pq2.peek();
                if (a <= b) {
                    sum += pq.peek() == null ? 0 : pq.poll();
                    if (c < half) pq.offer(costs[c++]);
                    else if (c == half && !halfUsed) {
                        halfUsed = true;
                        pq.offer(costs[c++]);
                    }
                } else {
                    sum += pq2.poll();
                    if (c2 > half) pq2.offer(costs[c2--]);
                    else if (c2 == half && !halfUsed) {
                        halfUsed = true;
                        pq.offer(costs[c2--]);
                    }
                }
            }
        }
        return sum;
    }

    static long totalCost2(int[] costs, int k, int n) {
        long sum = 0;
        if (costs.length % 2 == 0 && n >= costs.length / 2 || costs.length % 2 == 1 && n >= costs.length / 2 - 1) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < costs.length; i++) pq.offer(costs[i]);
            int count = 0;
            while (count++ < k) sum += pq.poll();
            return sum;
        }
        int half = costs.length / 2, count = 0, l = Math.min(half, n), r = Math.max(costs.length - n, costs.length % 2 == 0 ? half : half + 1);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        for (int i = 0; i < l; i++) pq1.offer(costs[i]);
        for (int i = costs.length - 1; i >= r; i--)
            pq2.offer(costs[i]);
        boolean halfUsed = false;
        if (costs.length % 2 == 1) r++;
        while (count < k) {
            int a = pq1.peek(), b = pq2.peek();
            if (a <= b) {
                sum += pq1.poll();
                if (l < half) pq1.offer(costs[l++]);
                if (l == half && costs.length % 2 == 1 && !halfUsed) {
                    halfUsed = true;
                    pq1.offer(costs[l++]);
                }
            } else {
                sum += pq2.poll();
                if (r > half) pq2.offer(costs[r--]);
                if (r == half && costs.length % 2 == 1 && !halfUsed) {
                    halfUsed = true;
                    pq2.offer(costs[r--]);
                }
            }
            count++;
        }
        return sum;
    }


    //Wrong Answer
    //
    //127 / 160
    //You're supposed to traverse first 'candidate' number of the array(elements from the beginning) and last 'candidate' number of elements from the ending of the array. Find the minimum element in it and then remove that element from the list. This minimum element you found is the cost of one worker. Now, repeat this process k times since we wanna hire k workers exactly.
    //
    //Ex: [3, ,5,1 2, 4, 1, 8, 2] and candidate = 2
    //-> Two elements from the beginning = 3, 5
    //-> Two elements at the end = 8, 2
    //Minimum element among 3, 5, 8, 2 is 2. That's the cost of one worker. Now that you have hired one worker, remove 2 from the array. Now, array will look like
    //[3, 5, 1, 2, 4, 1, 8]
    //Repeat the process K times.
    //
    //if ever you find two elements with the same value, you need to remove the element with the smallest index in the array. (In the above examples, there are two 1's in the array. When you encounter them, choose the one with the smallest index)
    //
    //Hope you got it.
    static long totalCost1(int[] costs, int k, int n) {
        long sum = 0;
        if (costs.length % 2 == 0 && n >= costs.length / 2 || costs.length % 2 == 1 && n >= costs.length / 2 + 1) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < costs.length; i++) pq.offer(costs[i]);
            int count = 0;
            while (count++ < k) sum += pq.poll();
            return sum;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        for (int i = 0; i < Math.min(costs.length / 2 + 1, n); i++) pq1.offer(costs[i]);
        for (int i = costs.length - 1; i >= Math.max(costs.length - n, costs.length / 2); i--) pq2.offer(costs[i]);
        int count = 0, l = n, r = costs.length - n - 1;
        while (count < k) {
            int a = pq1.peek(), b = pq2.peek();
            if (a <= b) {
                sum += pq1.poll();
                if (l < costs.length / 2 + 1) pq1.offer(costs[l++]);
            } else {
                sum += pq2.poll();
                if (r >= costs.length / 2) pq2.offer(costs[r--]);
            }
            count++;
        }
        return sum;
    }
}
