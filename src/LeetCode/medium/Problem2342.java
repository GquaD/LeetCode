package LeetCode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem2342 {
    //https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
    }

    //https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/solutions/3984370/java-map-of-priority-queues-o-nlogn/
    //8min
    //Runtime
    //52 ms
    //Beats
    //55.21%
    //Memory
    //54.3 MB
    //Beats
    //96.11%
    static int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int n : nums) map.computeIfAbsent(sumOfDigits(n), p -> new PriorityQueue<>(Comparator.reverseOrder())).offer(n);
        int max = -1;
        for (int key : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            if (pq.size() > 1) max = Math.max(pq.poll() + pq.poll(), max);
        }
        return max;
    }

    private static Integer sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
