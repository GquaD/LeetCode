package LeetCode.easy;

import java.util.TreeSet;

public class Problem414 {
    //10min
    //Runtime
    //7
    //ms
    //Beats
    //36.12%
    //Memory
    //47.49
    //MB
    //Beats
    //7.15%
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n: nums) {
            if (!set.contains(n))
                set.add(n);
            if (set.size() > 3)
                set.pollFirst();
        }

        if (set.size() == 3) return set.pollFirst();
        return set.pollLast();
    }
}
