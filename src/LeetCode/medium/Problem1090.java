package LeetCode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1090 {
    //https://leetcode.com/problems/largest-values-from-labels/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/largest-values-from-labels/solutions/3613908/java-using-priorityqueue-and-map/
    //10 min
    //Runtime
    //26 ms
    //Beats
    //10.61%
    //Memory
    //44.6 MB
    //Beats
    //87.15%
    static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getKey() - o1.getKey());
        for (int i = 0; i < values.length; i++) {
            pq.offer(new Pair<>(values[i], labels[i]));
        }
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty() && count < numWanted) {
            Pair<Integer, Integer> p = pq.poll();
            int val = p.getKey(), label = p.getValue(), freq = map.getOrDefault(label, 0);
            if (freq < useLimit) {
                sum += val;
                map.put(label, map.getOrDefault(label, 0) + 1);
                count++;
            }
        }
        return sum;
    }
}
