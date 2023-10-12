package LeetCode.medium;

import java.util.*;

public class Problem2766 {
    //https://leetcode.com/problems/relocate-marbles/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/relocate-marbles/solutions/4160908/java-simple-dimple-95-faster-solution/
    //5 min
    //Runtime
    //46 ms
    //Beats
    //95.39%
    //Memory
    //56.7 MB
    //Beats
    //96.31%
    static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        for (int i = 0; i < moveFrom.length; i++) {
            int a = moveFrom[i], b = moveTo[i];
            set.remove(a);
            set.add(b);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
