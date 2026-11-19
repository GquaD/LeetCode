package LeetCode.test;

import java.util.*;

public class Problem314 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue((a, b) -> Double.compare(b.distance, a.distance));
        for (int[] point: points) {
            pq.offer(new Point(point));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll().coordinates;

        return res;
    }
}

class Point {
    int[] coordinates;
    double distance;

    public Point(int[] arr) {
        coordinates = arr;
        distance = calculateDistance();
    }

    private double calculateDistance() {
        return Math.sqrt(coordinates[0] * coordinates[0] + coordinates[1] * coordinates[1]);
    }
}
