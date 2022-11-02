package LeetCode.easy;

public class Problem1779 {
    //https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
    public static void main(String[] args) {
        System.out.println(nearestValidPoint(3, 4, new int[][]{
                {1,2},
                {3,1},
                {2,4},
                {2,3},
                {4,4}
        }));
    }

    //https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/solutions/2769107/java-2-solutions/
    //Runtime
    //6 ms
    //Beats
    //47.95%
    //Memory
    //74.5 MB
    //Beats
    //11.82%
    static int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x) {
                int manh = Math.abs(y - points[i][1]);
                if (minSum > manh) {
                    minSum = manh;
                    result = i;
                }
            } else if (points[i][1] == y) {
                int manh = Math.abs(x - points[i][0]);
                if (minSum > manh) {
                    minSum = manh;
                    result = i;
                }
            }
        }
        return result;
    }


    //5-10min
    //Runtime
    //13 ms
    //Beats
    //12.63%
    //Memory
    //71.8 MB
    //Beats
    //49%
    static int nearestValidPoint1(int x, int y, int[][] points) {
        int result = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int manh = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (min > manh) {
                    min = manh;
                    result = i;
                }
            }
        }
        return result;
    }
}
