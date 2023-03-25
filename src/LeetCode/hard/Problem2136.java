package LeetCode.hard;

import java.util.*;

public class Problem2136 {
    //https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
    public static void main(String[] args) {
        //227
        System.out.println(earliestFullBloom(new int[]{3,11,29,4,4,26,26,12,13,10,30,19,27,2,10}, new int[]{10,13,22,17,18,15,21,11,24,14,18,23,1,30,6}));
        System.out.println(earliestFullBloom(new int[]{1,4,3}, new int[]{2,3,1}));
        System.out.println(earliestFullBloom(new int[]{1,2,3,2}, new int[]{2,1,2,1}));
        System.out.println(earliestFullBloom(new int[]{1}, new int[]{1}));
    }

    //wrong
    //175/185
    static int earliestFullBloom(int[] plantTime, int[] growTime) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        int minGrowTime = 10_001;
        for (int i = 0; i < growTime.length; i++) {
            int t = plantTime[i];
            if (map.containsKey(t)) {
                map.get(t).add(growTime[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(growTime[i]);
                map.put(t, list);
            }
            if (minGrowTime > growTime[i])
                minGrowTime = growTime[i];
        }
        int count = 0;
        for (int t : map.keySet()) {
            //overall plant time
            count += t * map.get(t).size();
        }
        return count + minGrowTime;
    }
}
