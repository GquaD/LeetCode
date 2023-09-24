package LeetCode.medium;

import java.util.*;

public class Problem2150 {
    //https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //80 ms
    //Beats
    //26.72%
    //Memory
    //63.2 MB
    //Beats
    //32.25%
    static List<Integer> findLonely1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int n : nums) if (map.get(n) == 1 && !map.containsKey(n - 1) && !map.containsKey(n + 1)) list.add(n);
        return list;
    }
}
