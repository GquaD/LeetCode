package LeetCode.medium;

import java.util.*;

public class Problem3237 {
    //https://leetcode.com/problems/alt-and-tab-simulation/


    //https://leetcode.com/problems/alt-and-tab-simulation/solutions/5579913/java-stack-set-solution/
    //5min
    //Runtime
    //83
    //ms
    //Beats
    //5.00%
    //Analyze Complexity
    //Memory
    //65.49
    //MB
    //Beats
    //60.00%
    public int[] simulationResult(int[] windows, int[] queries) {
        Stack<Integer> stack = new Stack<>();
        for (int n : queries) {
            stack.push(n);
        }
        int idx = 0, arr[] = new int[windows.length];
        Set<Integer> set = new HashSet<>();
        while (stack.size() > 0) {
            int cur = stack.pop();
            if (!set.contains(cur)) {
                set.add(cur);
                arr[idx++] = cur;
            }
        }
        for (int cur : windows) {
            if (!set.contains(cur)) {
                set.add(cur);
                arr[idx++] = cur;
            }
        }
        return arr;
    }
}
