package LeetCode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2418 {
    //https://leetcode.com/problems/sort-the-people/
    public static void main(String[] args) {

    }

    //Runtime
    //40 ms
    //Beats
    //15.6%
    //Memory
    //55 MB
    //Beats
    //10.79%
    static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        List<Integer> list = map.keySet()
                .stream()
                .sorted((o1, o2) -> o2.intValue() - o1.intValue())
                .collect(Collectors.toList());
        int count = 0;
        for (Integer key : list) {
            names[count++] = map.get(key);
        }
        return names;
    }


    //Runtime
    //20 ms
    //Beats
    //40.82%
    //Memory
    //54.2 MB
    //Beats
    //75.37%
    static String[] sortPeople1(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        int count = 0;
        for (Integer key : map.keySet()) {
            names[count++] = map.get(key);
        }
        return names;
    }
}
