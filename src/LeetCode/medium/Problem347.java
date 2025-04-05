package LeetCode.medium;

import java.util.*;

public class Problem347 {
    //https://leetcode.com/problems/top-k-frequent-elements/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    //5min
    //Runtime
    //13
    //ms
    //Beats
    //76.33%
    //Analyze Complexity
    //Memory
    //49.40
    //MB
    //Beats
    //10.29%
    //    public int[] topKFrequent(int[] nums, int k) {
    //        Map<Integer, Integer> map = new HashMap<>();
    //        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
    //        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.f - b.f);
    //        for (int key: map.keySet()) {
    //            pq.offer(new Pair(key, map.get(key)));
    //            if (pq.size() > k) pq.poll();
    //        }
    //        int[] res = new int[k];
    //        for (int i = 0; i < k; i++) res[i] = pq.poll().n;
    //        return res;
    //    }
    //
    //    class Pair {
    //        int n, f;
    //
    //        public Pair(int a, int b) {
    //            n = a;
    //            f = b;
    //        }
    //    }

    //Runtime
    //13 ms
    //Beats
    //54.17%
    //Memory
    //44.8 MB
    //Beats
    //76.60%
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        for (int key : map.keySet()) pq.offer(new Pair(key, map.get(key)));
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = pq.poll().val;
        return arr;
    }

    //Runtime
    //43 ms
    //Beats
    //5.44%
    //Memory
    //44.8 MB
    //Beats
    //66.12%
    static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            int maxF = 0, keyToDelete = -10_001;
            for (Map.Entry entry: map.entrySet()) {
                int f = (int) entry.getValue();
                if (maxF < f) {
                    maxF = f;
                    keyToDelete = (int) entry.getKey();
                }
            }
            arr[i] = keyToDelete;
            map.remove(keyToDelete);
        }
        return arr;
    }

    //Runtime
    //46 ms
    //Beats
    //5.13%
    //Memory
    //44.8 MB
    //Beats
    //76.60%
    static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int n : nums) {
            Pair p = map.getOrDefault(n, new Pair(n, 0));
            p.freq++;
            map.put(n, p);
        }
        int[] arr = new int[k];
        Set<Pair> set = new HashSet<>(map.values());
        for (int i = 0; i < k; i++) {
            Pair temp = new Pair(0, 0);
            for (Pair p : set) {
                if (temp.freq < p.freq) temp = p;
            }
            arr[i] = temp.val;
            set.remove(temp);
        }
        return arr;
    }

    private static void moveRight(int[] arr, int idx, int val) {
        int temp = arr[idx], temp2;
        arr[idx] = val;
        for (int i = idx + 1; i < arr.length; i++) {
            temp2 = arr[i];
            arr[i] = temp;
            temp = temp2;
        }
    }

    static class Pair {
        int val, freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int getVal() {
            return val;
        }

        public int getFreq() {
            return freq;
        }
    }
}
