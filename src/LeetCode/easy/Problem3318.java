package LeetCode.easy;

import java.util.*;

public class Problem3318 {
    //https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/solutions/6631181/java-easy-solution-explained-by-tbekpro-pw78/
    //
    //10min
    //Runtime
    //11
    //ms
    //Beats
    //83.08%
    //Analyze Complexity
    //Memory
    //45.75
    //MB
    //Beats
    //27.41%
    public int[] findXSum(int[] nums, int k, int x) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = findSum(nums, i, i + k, x);
        }
        return result;
    }

    private int findSum(int[] nums, int i, int j, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = i; k < j; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.val - b.val : a.freq - b.freq);
        for (int key : map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
            if (pq.size() > x)
                pq.poll();
        }

        int sum = 0;
        while (pq.size() > 0) {
            Pair p = pq.poll();
            sum += p.freq * p.val;
        }

        return sum;
    }

    class Pair {
        int val, freq;

        public Pair(int v, int f) {
            val = v;
            freq = f;
        }
    }
}
