package LeetCode.easy;

public class Problem4056 {
    //5min

    //Runtime
    //5
    //ms
    //Beats
    //-%
    //Memory
    //47.04
    //MB
    //Beats
    //-%
    public int countIntersectingIntervals(int[][] intervals) {
        int ins = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                int a = intervals[i][0], b = intervals[i][1], a1 = intervals[j][0], b1 = intervals[j][1];
                if (a <= a1 && b >= a1 || a1 <= a && b1 >= a) ins++;
            }
        }

        return ins;
    }
}
