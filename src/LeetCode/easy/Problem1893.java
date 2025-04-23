package LeetCode.easy;

import java.util.*;

public class Problem1893 {
    //https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/solutions/6680118/java-4-line-solution-by-tbekpro-08ba/
    //5min
    //Runtime
    //4
    //ms
    //Beats
    //10.09%
    //Analyze Complexity
    //Memory
    //41.55
    //MB
    //Beats
    //90.62%
    public boolean isCovered1(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for (int[] arr: ranges) for (int i = arr[0]; i <= arr[1]; i++) set.add(i);
        for (int i = left; i <= right; i++) if (!set.contains(i)) return false;
        return true;
    }
}
