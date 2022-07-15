package LeetCode.medium;

import java.util.Arrays;

public class Problem1637 {
    //https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

    //Runtime: 14 ms, faster than 99.07% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
    //Memory Usage: 70 MB, less than 96.73% of Java online submissions for Widest Vertical Area Between Two Points Containing No Points.
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][]{
                {8,7},
                {9,9},
                {7,4},
                {9,7}
        }));

        System.out.println(maxWidthOfVerticalArea(new int[][]{
                {3,1},
                {9,0},
                {1,0},
                {1,4},
                {5,3},
                {8,8}
        }));
    }

    static int maxWidthOfVerticalArea(int[][] points) {
        int[] dist = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            dist[i] = points[i][0];
        }
        Arrays.sort(dist);
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            int delta = dist[i] - dist[i - 1];
            if (max < delta) {
                max = delta;
            }
        }
        return max;
    }
}
