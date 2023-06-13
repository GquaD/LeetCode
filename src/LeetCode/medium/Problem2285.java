package LeetCode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem2285 {
    //https://leetcode.com/problems/maximum-total-importance-of-roads/
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][]{{0, 3}, {2, 4}, {1, 3}}));
    }

    //https://leetcode.com/problems/maximum-total-importance-of-roads/solutions/3634053/java-using-priorityqueue-and-map/
    //20-25 min
    //Runtime
    //121 ms
    //Beats
    //11.11%
    //Memory
    //60.5 MB
    //Beats
    //85.71%
    static long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : roads) {
            map.put(r[0], map.getOrDefault(r[0], 0) + 1);
            map.put(r[1], map.getOrDefault(r[1], 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (int city : map.keySet()) pq.offer(new Pair<>(city, map.get(city)));
        Map<Integer, Integer> mapPoints = new HashMap<>();
        int count = n;
        while (!pq.isEmpty()) mapPoints.put(pq.poll().getKey(), count--);
        long sum = 0;
        for (int[] r : roads) sum += mapPoints.get(r[0]) + mapPoints.get(r[1]);
        return sum;
    }

    static long maximumImportance1(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : roads) {
            map.put(r[0], map.getOrDefault(r[0], 0) + r[1]);
            map.put(r[1], map.getOrDefault(r[1], 0) + r[0]);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (int city : map.keySet()) pq.offer(new Pair<>(city, map.get(city)));
        Map<Integer, Integer> mapPoints = new HashMap<>();
        int count = 1;
        while (!pq.isEmpty()) mapPoints.put(pq.poll().getKey(), count++);
        int sum = 0;
        for (int[] r : roads) sum += mapPoints.get(r[0]) + mapPoints.get(r[1]);
        return sum;
    }
}
