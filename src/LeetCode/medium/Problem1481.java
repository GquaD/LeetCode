package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Problem1481 {
    //https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
    }

    //https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/solutions/3646924/java-o-n-6-line-solution-using-map-and-priorityqueue/
    //Runtime
    //66 ms
    //Beats
    //52.45%
    //Memory
    //58.8 MB
    //Beats
    //28.50%
    static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int key : map.keySet()) pq.offer(map.get(key));
        while (k >= pq.peek()) k -= pq.poll();
        return pq.size();
    }

    static int findLeastNumOfUniqueInts1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        int numberUnique = map.keySet().size();
        TreeMap<Integer, Integer> mapFreq = new TreeMap<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            mapFreq.put(freq, mapFreq.getOrDefault(freq, 0) + 1);
        }
        for (int freq : mapFreq.keySet()) {
            int num = mapFreq.get(freq), check = 0;
            for (int i = 0; i < freq; i++) {
                if (k - num >= 0) {
                    k -= num;
                    numberUnique--;
                } else {
                    check++;
                    break;
                }
            }
            if (check > 0) break;
        }
        return numberUnique;
    }
}
