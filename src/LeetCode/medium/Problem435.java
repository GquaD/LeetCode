package LeetCode.medium;

import java.util.Arrays;
import java.util.TreeMap;

public class Problem435 {
    //https://leetcode.com/problems/non-overlapping-intervals/
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {-100, -87}, {-90, -44}, {-86, 7}, {-85, -76}, {-70, 33}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{-73, -26}, {-65, -11}, {-62, -49}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    //https://leetcode.com/problems/non-overlapping-intervals/solutions/4199494/java-o-nlogn-sort-compare-solution/
    //5-10min
    //Runtime
    //59 ms
    //Beats
    //16.54%
    //Memory
    //100.6 MB
    //Beats
    //24.78%
    static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] prev = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[0] < curr[1] && prev[1] > curr[0]) count++;
            else prev = curr;
        }
        return count;
    }

    //
    static int eraseOverlapIntervals1(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : intervals) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            map.put(arr[1], map.getOrDefault(arr[1], 0) - 1);
        }

        int count = 0, prev = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            prev += value;
            map.put(key, prev);
        }
        prev = 0;
        int max = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (prev > 1 && value < prev) {
                if (value == 0) max = 0;
                if (prev > max) {
                    count += prev - Math.max(value, 1);
                    max = Math.max(value, max);
                }
            }
            prev = value;
        }
        return count;
    }
}
