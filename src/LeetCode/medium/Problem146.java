package LeetCode.medium;

import java.util.*;

public class Problem146 {
    //https://leetcode.com/problems/lru-cache/description/

    //15-20 min
    //Runtime
    //77 ms
    //Beats
    //22.80%
    //Memory
    //118.7 MB
    //Beats
    //23.32%
    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> map;
        public LRUCache(int capacity) {
            cap = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int v = map.get(key);
                map.remove(key);
                map.put(key, v);
                return v;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.size() < cap) {
                if (!map.containsKey(key)) {
                    map.put(key, value);
                } else {
                    map.remove(key);
                    map.put(key, value);
                }
            } else if (!map.containsKey(key)){
                for (int k : map.keySet()) {
                    map.remove(k);
                    break;
                }
                map.put(key, value);
            } else {
                map.remove(key);
                map.put(key, value);
            }
        }
    }

    class LRUCache2 {
        Map<Integer, Integer> mapP;
        Map<Integer, Integer> mapK;
        int cap, position, maxPosition;
        public LRUCache2(int capacity) {
            cap = capacity;
            mapP = new HashMap<>();
            mapK = new HashMap<>();
            position = Integer.MAX_VALUE;
            maxPosition = position;
        }

        public int get(int key) {
            position--;
            mapP.put(position, key);
            return mapK.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (mapK.size() == cap) {
                int keyMax = mapP.remove(maxPosition--);
                mapK.remove(keyMax);
            }
            mapP.put(key, position--);
            mapK.put(key, value);
        }
    }

    static class LRUCache1 {
        PriorityQueue<Pair> queue;
        Map<Integer, Integer> map;
        int cap;
        Pair toEvict;
        public LRUCache1(int capacity) {
            queue = new PriorityQueue<>((a, b) -> b.time - a.time);
            map = new HashMap<>();
            cap = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                queue.offer(null);
            }
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            for (Pair p : queue) p.time++;
            if (queue.size() == cap) toEvict = queue.poll();
            Pair newPair = new Pair(value, 1);
            //map.put()
        }
    }

    static class Pair {
        int key, time;

        public Pair(int val, int time) {
            this.key = val;
            this.time = time;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
