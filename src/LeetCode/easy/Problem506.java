package LeetCode.easy;

import javafx.util.Pair;

import java.util.*;

public class Problem506 {
    //https://leetcode.com/problems/relative-ranks/
    public static void main(String[] args) {

    }

    //5-10 min
    //Runtime
    //11 ms
    //Beats
    //41.70%
    //Memory
    //45 MB
    //Beats
    //50.45%
    static Map<Integer, String> map;
    static String[] findRelativeRanks(int[] score) {
        if (map == null) generateMap();
        Pair<Integer, Integer>[] arr = new Pair[score.length];
        for (int i = 0; i < score.length; i++) arr[i] = new Pair<>(score[i], i);
        Arrays.sort(arr, (a, b) -> b.getKey() - a.getKey());
        String[] res = new String[arr.length];
        for (int pos = 0; pos < arr.length; pos++) {
            String word = map.get(pos + 1) == null ? (pos + 1) + "" : map.get(pos + 1);
            res[arr[pos].getValue()] = word;
        }
        return res;
    }

    private static void generateMap() {
        map = new HashMap<>();
        map.put(1, "Gold Medal");
        map.put(2, "Silver Medal");
        map.put(3, "Bronze Medal");
    }


    static String[] findRelativeRanks2(int[] score) {
        int[] arrSorted = Arrays.copyOf(score, score.length);
        Arrays.sort(arrSorted);
        return null;
    }

    static String[] findRelativeRanks1(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("Bronze Medal");
        queue.add("Silver Medal");
        queue.add("Gold Medal");
        for (int n : score) {
            pq.offer(n);
            if (pq.size() > 3) pq.poll();
        }
        Map<Integer, String> map = new HashMap<>();
        if (pq.size() == 3) {
            queue.add("Bronze Medal");
            queue.add("Silver Medal");
            queue.add("Gold Medal");
        } else if (pq.size() == 2) {
            queue.add("Silver Medal");
            queue.add("Gold Medal");
        } else {
            queue.add("Gold Medal");
        }
        while (!pq.isEmpty()) {
            map.put(pq.poll(), queue.poll());
        }
        String[] arr = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (map.containsKey(score[i])) {
                arr[i] = map.get(score[i]);
            } else {
                arr[i] = score[i] + "";
            }
        }
        return arr;
    }
}
