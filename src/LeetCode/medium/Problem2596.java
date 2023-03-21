package LeetCode.medium;

import java.util.*;

public class Problem2596 {
    //https://leetcode.com/problems/check-knight-tour-configuration/
    public static void main(String[] args) {
        System.out.println(checkValidGrid(new int[][]{{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}}));
    }

    //https://leetcode.com/problems/check-knight-tour-configuration/solutions/3322861/java-6-ms-using-priorityqueue-and-coordinates/
    //Runtime
    //8 ms
    //Beats
    //6.73%
    //Memory
    //42.3 MB
    //Beats
    //71%
    static boolean checkValidGrid(int[][] grid) {
        Map<Integer, Coordinates> map = new HashMap<>();
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[0].length; x++)
                map.put(grid[y][x], new Coordinates(y, x));

        TreeSet<Integer> keys = new TreeSet<>(map.keySet());
        Integer prevKey = keys.pollFirst();
        Coordinates prev = map.get(prevKey);
        if (!(prev.x == 0 && prev.y == 0)) return false;
        while (!keys.isEmpty()) {
            Coordinates curr = map.get(keys.pollFirst());
            if (!isValidMove(prev, curr)) return false;
            prev = curr;
        }
        return true;
    }

    //Runtime
    //6 ms
    //Beats
    //9.21%
    //Memory
    //42.4 MB
    //Beats
    //46.81%
    static boolean checkValidGrid1(int[][] grid) {
        PriorityQueue<Coordinates> pq = new PriorityQueue<>(Comparator.comparing(Coordinates::getNum));
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[0].length; x++)
                pq.offer(new Coordinates(y, x, grid[y][x]));

        Coordinates prev = pq.poll();
        if (!(prev.x == 0 && prev.y == 0)) return false;
        while (!pq.isEmpty()) {
            Coordinates curr = pq.poll();
            if (!isValidMove(prev, curr)) return false;
            prev = curr;
        }
        return true;
    }

    private static boolean isValidMove(Coordinates prev, Coordinates curr) {
        return Math.abs(prev.x - curr.x) == 1 && Math.abs(prev.y - curr.y) == 2
                || Math.abs(prev.x - curr.x) == 2 && Math.abs(prev.y - curr.y) == 1;
    }


    static class Coordinates {
        int y, x, num;

        public Coordinates(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }

        public Coordinates(int y, int x) {
            this.y = y;
            this.x = x;
            this.num = 0;
        }

        public int getNum() {
            return num;
        }
    }
}
