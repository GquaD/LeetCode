package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem56 {
    //https://leetcode.com/problems/merge-intervals/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(merge(new int[][]{
                {1,4},
                {4,5}
        }));

        LeetCodeUtils.print2DArray(merge(new int[][]{
                {1,4},
                {0,4}
        }));
        LeetCodeUtils.print2DArray(merge(new int[][]{
                {1,4},
                {2,3}
        }));
    }


    //15min
    //Runtime
    //8
    //ms
    //Beats
    //90.11%
    //Memory
    //48.95
    //MB
    //Beats
    //74.71%
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            int[] last = list.get(list.size() - 1);
            if (prevEnd >= curStart) {
                if (curEnd <= prevEnd) continue;
                if (curEnd > prevEnd) last[1] = curEnd;
            } else {
                list.add(intervals[i]);
            }

            prevEnd = curEnd;
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    //https://leetcode.com/problems/merge-intervals/solutions/2832657/java-95-time-96-memory-solution/
    //40 mins
    //Runtime
    //8 ms
    //Beats
    //95.2%
    //Memory
    //46.9 MB
    //Beats
    //96.25%
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0, start = intervals[0][0], end = intervals[0][1];
        int[][] resTemp = new int[intervals.length][2];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= end) {
                end = Math.max(e, end);
            } else {
                resTemp[count][0] = start;
                resTemp[count++][1] = end;
                start = s;
                end = e;
            }
        }
        resTemp[count][0] = start;
        resTemp[count++][1] = end;
        int[][] res = new int[count][2];
        for (int i = 0; i < count; i++) {
            res[i] = resTemp[i];
        }
        return res;
    }
}
