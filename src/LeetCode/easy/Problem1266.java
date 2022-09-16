package LeetCode.easy;

public class Problem1266 {
    //https://leetcode.com/problems/minimum-time-visiting-all-points/
    public static void main(String[] args) {
        System.out.println(minTimeToVisitAllPoints(new int[][]{
                {1,1},
                {3,4},
                {-1,0}
        }));
        System.out.println(minTimeToVisitAllPoints(new int[][]{
                {3,2},
                {-2,2}
        }));
    }

    //Runtime: 1 ms, faster than 95.57% of Java online submissions for Minimum Time Visiting All Points.
    //Memory Usage: 43.7 MB, less than 45.80% of Java online submissions for Minimum Time Visiting All Points.
    static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            int xAbs = Math.abs(points[i][0] - points[i - 1][0]);
            int yAbs = Math.abs(points[i][1] - points[i - 1][1]);
            sum += Math.max(xAbs, yAbs);
        }
        return sum;
    }
}
