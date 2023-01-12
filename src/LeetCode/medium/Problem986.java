package LeetCode.medium;


import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem986 {
    //https://leetcode.com/problems/interval-list-intersections/

    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(intervalIntersection(new int[][] {
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        }, new int[][] {
                {1,5},
                {8,12},
                {15,24},
                {25,26},
        }));
    }

    //30 - 40 mins
    //https://leetcode.com/problems/interval-list-intersections/solutions/3039206/java-o-n-nlogn-solution/
    //Runtime
    //15 ms
    //Beats
    //25.29%
    //Memory
    //43.7 MB
    //Beats
    //53.12%
    static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Point> list = new ArrayList<>();
        for (int[] p : firstList) {
            list.add(new Point(p[0], true));
            list.add(new Point(p[1], false));
        }
        for (int[] p : secondList) {
            list.add(new Point(p[0], true));
            list.add(new Point(p[1], false));
        }
        Collections.sort(list, Comparator.comparing(Point::getValue).thenComparing(p -> !p.isStart));
        int[] arr = new int[list.size()];
        int count = 0, size = 0;
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            if (p.isStart) count++;
            else count--;
            if (count == 2) size++;
            arr[i] = count;
        }
        int[][] res = new int[size][2];
        int idx = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] == 2) {
                Point first = list.get(i - 1), second = list.get(i);
                int[] r = new int[]{first.value, second.value};
                res[idx++] = r;
            }
        }
        return res;
    }

    static class Point {
        int value;
        boolean isStart;

        public Point(int value, boolean isStart) {
            this.value = value;
            this.isStart = isStart;
        }

        public int getValue() {
            return value;
        }

        public boolean isStart() {
            return isStart;
        }
    }

    static int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
        List<Position> list = new ArrayList<>();
        for (int[] arr : firstList) {
            Position start = new Position(true, arr[0]);
            Position end = new Position(false, arr[1]);
            list.add(start);
            list.add(end);
        }
        for (int[] arr : secondList) {
            Position start = new Position(true, arr[0]);
            Position end = new Position(false, arr[1]);
            list.add(start);
            list.add(end);
        }

        Collections.sort(list, Comparator.comparing(Position::getIndex));
        List<Pair> pairs = new ArrayList<>();
        Pair current = new Pair();
        int idx = 0;
        while (idx < list.size()) {
            Position pos = list.get(idx);
            if (pos.isStart()) {
                current.setStart(pos.getIndex());
            } else {
                current.setEnd(pos.index);
                if (current.getStart() != -1) {
                    pairs.add(current);
                }
                current = new Pair();
            }
            if (idx - 1 > -1) {
                Position prev = list.get(idx - 1);
                if (prev.getIndex() == pos.getIndex() && !prev.isStart() && pos.isStart()) {
                    current.setStart(pos.index);
                    current.setEnd(prev.index);
                    pairs.add(current);
                    current = new Pair();
                }
            }
            idx++;
        }
        int[][] result = new int[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            result[i][0] = pairs.get(i).getStart();
            result[i][1] = pairs.get(i).getEnd();
        }
        return result;
    }

    static class Position {
        boolean isStart;
        int index;

        public Position(boolean isStart, int index) {
            this.isStart = isStart;
            this.index = index;
        }

        public boolean isStart() {
            return isStart;
        }

        public int getIndex() {
            return index;
        }
    }

    static class Pair {
        int start;
        int end;

        public Pair() {
            start = -1;
            end = -1;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
