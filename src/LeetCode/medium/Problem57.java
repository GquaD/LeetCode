package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Problem57 {
    //https://leetcode.com/problems/insert-interval/
    public static void main(String[] args) {

    }

    static int[][] insert(int[][] ints, int[] newInterval) {
        int[][] intervals = new int[ints.length + 1][2];
        for (int i = 0; i < ints.length; i++) {
            intervals[i][0] = ints[i][0];
            intervals[i][1] = ints[i][1];
        }
        intervals[intervals.length - 1][0] = newInterval[0];
        intervals[intervals.length - 1][1] = newInterval[1];
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
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
