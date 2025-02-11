package LeetCode.easy;

import java.util.*;

public class Problem3450 {
    //https://leetcode.com/problems/maximum-students-on-a-single-bench
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-students-on-a-single-bench/solutions/6408112/java-straightforward-solution-by-tbekpro-u1r7/
    //Runtime
    //4
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.21
    //MB
    //Beats
    //100.00%
    public int maxStudentsOnBench(int[][] students) {
        int max = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr: students) {
            int s = arr[0], b = arr[1];
            Set<Integer> set = map.get(b);
            if (set == null) {
                set = new HashSet<>();
                map.put(b, set);
            }
            set.add(s);
            max = Math.max(max, set.size());
        }
        return max;
    }


    //
    //3min
    //Runtime
    //6
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.92
    //MB
    //Beats
    //100.00%
    public int maxStudentsOnBench2(int[][] students) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr: students) {
            int s = arr[0], b = arr[1];
            Set<Integer> set = map.get(b);
            if (set == null) {
                set = new HashSet<>();
                map.put(b, set);
            }
            set.add(s);
        }
        int max = 0;
        for (int bench: map.keySet()) {
            max = Math.max(max, map.get(bench).size());
        }
        return max;
    }
}
