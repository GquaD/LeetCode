package LeetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem452 {
    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{31176229,84553602},{59484421,74029340},{8413784,65312321},{34575198,108169522},{49798315,88462685},{29566413,114369939},{12776091,37045071},{11759956,61001829},{37806862,80806032},{82906996,118404277}}));
        System.out.println(findMinArrowShots(new int[][]{{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}}));
        System.out.println(findMinArrowShots(new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        }));
    }

    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/solutions/3002041/java-solution-sorted-array/
    //30 mins
    //Runtime
    //117 ms
    //Beats
    //49.69%
    //Memory
    //79.7 MB
    //Beats
    //76.99%
    static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(ints -> ((int[])ints)[0]).thenComparingInt(value -> ((int[])value)[1]));
        int count = 1, nextIdx = 0;
        outerloop:
        while(nextIdx < points.length) {
            int[] p = points[nextIdx];
            boolean idxChanged = false;
            for (int j = nextIdx + 1; j < points.length; j++) {
                int[] temp = points[j];
                if (temp[1] < p[1]) p[1] = temp[1];
                if (p[1] < temp[0]) {
                    idxChanged = true;
                    nextIdx = j;
                    count++;
                    break;
                }
                if (nextIdx + 1 == points.length - 1) break outerloop;
            }
            if (!idxChanged) nextIdx++;
        }
        return count;
    }
}
