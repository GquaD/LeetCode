package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2644 {
    //https://leetcode.com/problems/find-the-maximum-divisibility-score
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //1139
    //ms
    //Beats
    //5.66%
    //Analyze Complexity
    //Memory
    //45.08
    //MB
    //Beats
    //65.57%
    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d: divisors) map.put(d, 0);
        for (int n: nums) {
            for (int k: map.keySet()) {
                if (n % k == 0) {
                    map.put(k, map.get(k) + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE, freq = 0;
        for (int k: map.keySet()) {
            int f = map.get(k);
            if (f > freq) {
                res = k;
                freq = f;
            } else if (f == freq) {
                res = Math.min(res, k);
            }
        }
        return res;
    }
}
