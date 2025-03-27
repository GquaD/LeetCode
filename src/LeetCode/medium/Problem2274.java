package LeetCode.medium;

import java.util.Arrays;

public class Problem2274 {
    //https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/solutions/6584098/java-onlogn-solution-explained-by-tbekpr-bokl/
    //10min
    //Runtime
    //32
    //ms
    //Beats
    //12.08%
    //Analyze Complexity
    //Memory
    //55.38
    //MB
    //Beats
    //85.51%
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int idx = Arrays.binarySearch(special, bottom);
        idx = idx < 0 ? -idx - 1 : idx;
        int max = special[idx] - bottom;
        bottom = special[idx++];
        while (idx < special.length && special[idx] <= top) {
            max = Math.max(max, special[idx] - bottom - 1);
            bottom = special[idx++];
        }
        return Math.max(max, top - special[special.length - 1]);
    }
}
