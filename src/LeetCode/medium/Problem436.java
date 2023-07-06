package LeetCode.medium;

import java.util.*;

public class Problem436 {
    //https://leetcode.com/problems/find-right-interval/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1,2}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3,4}, {2,3}, {1,2}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1,4}, {2,3}, {3,4}})));
    }

    //https://leetcode.com/problems/find-right-interval/solutions/3728922/java-94-faster-sorting-binary-search/
    //1 hour
    //Runtime
    //12 ms
    //Beats
    //93.60%
    //Memory
    //45.7 MB
    //Beats
    //97.2%
    static int[] findRightInterval(int[][] is) {
        Interval[] arr = new Interval[is.length];
        for (int i = 0; i < is.length; i++) arr[i] = new Interval(is[i][0], is[i][1], i);
        Arrays.sort(arr, (a, b) -> a.start - b.start);
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Interval val = arr[i];
            int idx = Arrays.binarySearch(arr, new Interval(val.end));
            idx = idx < 0 ? -idx - 1 : idx;
            idx = idx >= is.length ? -1 : idx;
            res[val.idx] = idx == -1 ? -1 : arr[idx].idx;
        }
        return res;
    }

/*    //Wrong Answer
    //
    //19 / 20
    static int[] findRightInterval2(int[][] intervals) {
        int[][] indxs = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) indxs[i] = new int[]{intervals[i][0], i};
        Arrays.sort(indxs, (a, b) -> a[0] - b[0]);
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < intervals.length; i++) map.put(intervals[i][0], i);
        int[] arr = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int idx = Arrays.binarySearch(indxs, intervals[i]);
            idx = idx < 0 ? -idx - 1 : idx;
            arr[i] = idx == intervals.length - 1 ? -1 : idx;
            *//*Integer idx = map.get(intervals[i][1]);
            if (idx == null) {
                int lastKey = map.lastKey();
                idx = lastKey < intervals[i][1] ? -1 : map.get(lastKey);
            }
            arr[i] = idx;*//*
        }
        return arr;
    }

    static int[] findRightInterval1(int[][] intervals) {
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        Map<Integer, Integer> mapIdx = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int arr[] = intervals[i];
            int start = arr[0], end = arr[1];
            map.computeIfAbsent(start, k -> new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

            mapIdx.put(start, i);
        }
        return null;
    }*/
}

class Interval implements Comparable {
    int start, end, idx;

    public Interval(int start) {
        this.start = start;
    }

    public Interval(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
    }

    @Override
    public int compareTo(Object o) {
        return start - ((Interval)o).start;
    }
}
