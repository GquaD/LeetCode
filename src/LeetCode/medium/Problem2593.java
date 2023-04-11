package LeetCode.medium;

import java.util.*;

public class Problem2593 {
    //https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/solutions/3404496/java-treemap-set/
    //Runtime
    //287 ms
    //Beats
    //32.88%
    //Memory
    //85.9 MB
    //Beats
    //5.5%
    static long findScore(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) map.computeIfAbsent(nums[i], n -> new ArrayList<>()).add(i);
        Set<Integer> marked = new HashSet<>();
        long score = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int idx : list) {
                if (!marked.contains(idx)) {
                    score += key;
                    marked.add(idx);
                    marked.add(idx + 1);
                    marked.add(idx - 1);
                }
            }
        }
        return score;
    }

    //5-10 min
    //Runtime
    //663 ms
    //Beats
    //5.88%
    //Memory
    //60 MB
    //Beats
    //35.8%
    static long findScore1(int[] nums) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparing(iPair::getVal).thenComparing(iPair::getIdx));
        for (int i = 0; i < nums.length; i++) pq.offer(new iPair(nums[i], i));
        Set<Integer> setMarkedIdx = new HashSet<>();
        long score = 0;
        while (!pq.isEmpty()) {
            iPair pair = pq.poll();
            if (!setMarkedIdx.contains(pair.idx)) {
                score += pair.val;
                setMarkedIdx.add(pair.idx);
                setMarkedIdx.add(Math.max(pair.idx - 1, 0));
                setMarkedIdx.add(Math.min(pair.idx + 1, nums.length - 1));
            }
        }
        return score;
    }

    static class iPair {
        int val, idx;

        public iPair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public int getIdx() {
            return idx;
        }
    }
}
