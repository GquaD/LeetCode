package LeetCode.medium;

import java.util.*;

public class Problem2671 {
    //https://leetcode.com/problems/frequency-tracker/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/frequency-tracker/solutions/3539176/java-using-hashmap-as-a-frequency-map/
//40 min
//Runtime
//71 ms
//Beats
//40.72%
//Memory
//112.4 MB
//Beats
//36.60%

class FrequencyTracker {

    Map<Integer, Set<Integer>> map;

    public FrequencyTracker() {
        map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.put(1, new HashSet<>());
    }

    public void add(int number) {
        int f = -1;
        for (int freq : map.keySet()) {
            if (map.get(freq).contains(number)) {
                f = freq;
                break;
            }
        }
        if (f > -1) {
            map.get(f).remove(number);
            map.computeIfAbsent(f + 1, HashSet::new).add(number);
        } else {
            map.get(1).add(number);
        }
    }

    public void deleteOne(int number) {
        int f = -1;
        for (int freq : map.keySet()) {
            if (map.get(freq).contains(number)) {
                f = freq;
                break;
            }
        }
        if (f > 0) {
            map.get(f).remove(number);
            map.get(f - 1).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        return map.containsKey(frequency) && map.get(frequency).size() > 0;
    }
}


//Time Limit Exceeded
//1115 / 1118

class FrequencyTracker1 {
    Map<Integer, Integer> map;
    List<Integer> listFreq;

    public FrequencyTracker1() {
        map = new HashMap<>();
        listFreq = new ArrayList<>();
        listFreq.add(0);
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        int freq = map.get(number);
        listFreq.add(freq - 1, listFreq.get(freq - 1) - 1);
        if (listFreq.size() > freq) {
            listFreq.add(freq, listFreq.get(freq) + 1);
        } else {
            listFreq.add(1);
        }

    }

    public void deleteOne(int number) {
        map.put(number, Math.max(0, map.getOrDefault(number, 1) - 1));
        int freq = map.get(number);
        if (listFreq.size() > freq + 1) {
            listFreq.add(freq + 1, listFreq.get(freq + 1) - 1);
            listFreq.add(freq, listFreq.get(freq) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return listFreq.size() > frequency && listFreq.get(frequency) > 0;
    }
}
