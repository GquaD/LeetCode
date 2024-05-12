package LeetCode.medium;

import java.util.*;

public class Problem3143 {
    //https://leetcode.com/problems/maximum-points-inside-the-square
}

//https://leetcode.com/problems/maximum-points-inside-the-square/solutions/5148019/java-o-nlogn-solution/
//50min
//Runtime
//58
//ms
//Beats
//50.00%
//of users with Java
//Memory
//87.32
//MB
//Beats
//100.00%
//of users with Java
class Solution2 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        TreeMap<Integer, List<Point>> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            int x = points[i][0], y = points[i][1];
            char tag = s.charAt(i);
            int size = Math.max(Math.abs(x), Math.abs(y));

            List<Point> l = map.get(size);
            if (l == null) {
                l = new ArrayList<>();
                map.put(size, l);
            }
            l.add(new Point(x, y, tag, size));
        }

        int count = 0, curSize = 0;
        Set<Character> set = new HashSet<>();

        outerloop:
        for (int size : map.keySet()) {
            List<Point> l = map.get(size);
            int curCount = 0;
            for (Point p : l) {
                if (set.contains(p.tag)) {
                    break outerloop;
                }
                set.add(p.tag);
                curCount++;
            }
            curSize = size;
            count += curCount;
        }

        return count;
    }
}

class Point {
    int x, y;
    char tag;
    int size;

    public Point(int x, int y, char tag, int size) {
        this.x = x;
        this.y = y;
        this.tag = tag;
        this.size = size;
    }
}

/*class Solution2 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (int) (b.dist - a.dist));

        for (int i = 0; i < s.length(); i++) {
            int x = points[i][0], y = points[i][1];
            char tag = s.charAt(i);
            double dist = Math.sqrt(x * x + y * y);
            pq.offer(new Point(x, y, tag, dist));
        }

        int count = 0;
        Set<Character> set = new HashSet<>();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (set.contains(p.tag)) {
                break;
            }
            set.add(p.tag);
            count++;
        }
        return count;
    }
}

class Point {
    int x, y;
    char tag;
    double dist;

    public Point(int x, int y, char tag, double dist) {
        this.x = x;
        this.y = y;
        this.tag = tag;
        this.dist = dist;
    }
}*/
