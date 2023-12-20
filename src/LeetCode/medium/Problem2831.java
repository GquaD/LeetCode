package LeetCode.medium;

import java.util.*;

public class Problem2831 {
    //https://leetcode.com/problems/find-the-longest-equal-subarray/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-longest-equal-subarray/solutions/4430519/java-hashmap-of-indices-queue/
    //solved without IDE, just text editor
    //25-30min
    //Runtime
    //99 ms
    //Beats
    //20.78%
    //Memory
    //73.1 MB
    //Beats
    //5.19%
    static int longestEqualSubarray(List<Integer> nums, int k) {
        //num -> list idx
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> l = map.get(nums.get(i));
            if (l == null) {
                l = new ArrayList<>();
                map.put(nums.get(i), l);
            }
            l.add(i);
        }
        int max = 1;

        for (int key : map.keySet()) {
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> l = map.get(key);
            int t = k, count = 1;
            for (int i = 1; i < l.size(); i++) {
                int prev = l.get(i - 1), cur = l.get(i), diff = (cur - prev) - 1;
                t -= diff;
                queue.offer(diff);
                while (t < 0 && !queue.isEmpty()) {
                    t += queue.poll();
                    count--;
                }

                count++;
                max = Math.max(count, max);

            }
        }
        return max;
    }
}
