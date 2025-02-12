package LeetCode.medium;

import java.util.Arrays;

public class Problem1465 {
    //https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/solutions/6412916/java-onlogn-solution-by-tbekpro-g04n/
    //5min
    //Runtime
    //16
    //ms
    //Beats
    //49.79%
    //Analyze Complexity
    //Memory
    //55.39
    //MB
    //Beats
    //50.62%
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        int maxh = 0, maxw = 0;
        int starth = 0, startw = 0;
        Arrays.sort(hc);
        for (int i = 0; i < hc.length; i++) {
            maxh = Math.max(maxh, hc[i] - starth);
            starth = hc[i];
        }
        maxh = Math.max(maxh, h - starth);

        Arrays.sort(vc);
        for (int i = 0; i < vc.length; i++) {
            maxw = Math.max(maxw, vc[i] - startw);
            startw = vc[i];
        }
        maxw = Math.max(maxw, w - startw);
        return (int) ((1L * maxh * maxw) % 1_000_000_007L);
    }
}
