package LeetCode.easy;

import java.util.TreeMap;

public class Problem2148 {
    //https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/solutions/6524138/java-treemap-solution-by-tbekpro-ug6y/
    //3min
    //Runtime
    //3
    //ms
    //Beats
    //16.01%
    //Analyze Complexity
    //Memory
    //42.30
    //MB
    //Beats
    //8.15%
    public int countElements(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        if (map.size() < 3) return 0;
        int res = nums.length - map.get(map.firstKey()) - map.get(map.lastKey());
        return res;
    }
}
