package LeetCode.medium;

import java.util.Arrays;

public class Problem1828 {
    //https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
    public static void main(String[] args) {
        String result = Arrays.toString(countPoints(new int[][]{
                {1,3},
                {3,3},
                {5,3},
                {2,2}
        }, new int[][] {
                {2,3,1},
                {4,3,1},
                {1,1,2}
        }));
        System.out.println(result);
    }

    //Runtime: 56 ms, faster than 27.57% of Java online submissions for Queries on Number of Points Inside a Circle.
    //Memory Usage: 51 MB, less than 15.75% of Java online submissions for Queries on Number of Points Inside a Circle.
    static int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int xCircle = queries[i][0];
                int yCircle = queries[i][1];
                int radius = queries[i][2];
                int xPoint = points[j][0];
                int yPoint = points[j][1];
                // distance between 2 points
                // d = sqrt( (x2 - x1)^2 + (y2 - y1) )
                double d = Math.sqrt(Math.pow(xPoint - xCircle, 2) + Math.pow(yPoint - yCircle, 2));
                if (d <= radius) {
                    res[i] += 1;
                }
            }
        }
        return res;
    }
}
