package LeetCode.medium;

import java.util.*;

public class Problem2808 {
    //https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/
    public static void main(String[] args) {
        System.out.println(minimumSeconds(Arrays.asList(5,5,5,5)));
        System.out.println(minimumSeconds(Arrays.asList(2,1,3,3,2)));
        System.out.println(minimumSeconds(Arrays.asList(1,2,1,2)));
    }

    //Memory Limit Exceeded
    //553 / 579
    static int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> mapIdx = new HashMap<>();
        for (int i = 0; i < nums.size(); i++)
            mapIdx.computeIfAbsent(nums.get(i), ArrayList::new).add(i);
        int count = Integer.MAX_VALUE;
        for (int key : mapIdx.keySet()) {
            List<Integer> listIdx = mapIdx.get(key);
            listIdx.add(listIdx.get(0) + nums.size());
            int max = 0;
            for (int i = 1; i < listIdx.size(); i++)
                max = Math.max(max, (listIdx.get(i) - listIdx.get(i - 1)) / 2);
            count = Math.min(count, max);
        }
        return count;
    }
    static int minimumSeconds2(List<Integer> nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        Map<Integer, List<Integer>> mapIdx = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            mapFreq.put(nums.get(i), mapFreq.getOrDefault(nums.get(i), 0) + 1);
            mapIdx.computeIfAbsent(nums.get(i), ArrayList::new);
            mapIdx.get(nums.get(i)).add(i);
        }
        int maxFreq = 1, maxFreqVal = nums.get(nums.size() / 2);
        for (int key : mapFreq.keySet()) {
            int freq = mapFreq.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqVal = key;
            }
        }
        if (maxFreq == nums.size()) return 0;
        int count = 0;
        List<Integer> listIdx = mapIdx.get(maxFreqVal);
        for (int i = 0; i < listIdx.size(); i++) {
            int idx = listIdx.get(i), idx1 = i + 1 == listIdx.size() ? nums.size() - idx - 1 + listIdx.get(0) : listIdx.get(i + 1);
            int diff = Math.abs(idx1 - idx);
            count = Math.max(count, diff / 2);
        }
        return count;
    }

    static int minimumSeconds1(List<Integer> nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        Map<Integer, List<Integer>> mapIdx = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            mapFreq.put(nums.get(i), mapFreq.getOrDefault(nums.get(i), 0) + 1);
            mapIdx.computeIfAbsent(nums.get(i), ArrayList::new);
            mapIdx.get(nums.get(i)).add(i);
        }
        int maxFreq = 1, maxFreqVal = nums.get(nums.size() / 2);
        for (int key : mapFreq.keySet()) {
            int freq = mapFreq.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqVal = key;
            }
        }
        if (maxFreq == nums.size()) return 0;
        int count = 0;
        List<Integer> listIdx = mapIdx.get(maxFreqVal);
        for (int i = 0; i < nums.size(); i++) {
            int minDiff = nums.size();
            for (int j = 0; j < listIdx.size(); j++) {
                int diff = Math.abs(i - listIdx.get(j));
                minDiff = Math.min(diff, minDiff);
            }
            count = Math.max(minDiff, count);
            /*else {
                idx = idx < 0 ? -idx - 1 : idx;
                int diff = Math.abs(i - listIdx.get(idx));
                count = Math.max(diff, count);
            }*/
        }
        return count;
    }
}
