package LeetCode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem732 {
    //https://leetcode.com/problems/my-calendar-iii/description/
    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(25, 55));
    }

    //hhhh
    //Runtime
    //649 ms
    //Beats
    //7.13%
    //Memory
    //42.6 MB
    //Beats
    //95.72%
    static class MyCalendarThree {
        Map<Integer, Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            if (map.containsKey(startTime))
                map.put(startTime, map.get(startTime) + 1);
            else
                map.put(startTime, 1);

            if (map.containsKey(endTime))
                map.put(endTime, map.get(endTime) - 1);
            else
                map.put(endTime, -1);

            int maxCurr = 0, accum = 0;
            for (int time : map.keySet()) {
                accum += map.get(time);
                if (maxCurr < accum) maxCurr = accum;
            }
            return maxCurr;
        }
    }

    static class MyCalendarThree1 {
        int[][] arr;
        int idx;
        int maxK;

        public MyCalendarThree1() {
            arr = new int[400][2];
            idx = 0;
            maxK = 0;
        }

        public int book(int startTime, int endTime) {
            int sumIntersections = 1, tempSum = 0;

            arr[idx][0] = startTime;
            arr[idx][1] = endTime;
            for (int i = 0; i <= idx; i++) {
                for (int j = 0; j <= idx; j++) {
                    if (arr[i][0] < arr[j][1] && arr[i][1] > arr[j][0] && j != i) {
                        sumIntersections++;
                    }
                }
                if (tempSum < sumIntersections) {
                    tempSum = sumIntersections;
                }
                sumIntersections = 1;
            }

            if (tempSum > maxK) maxK = tempSum;
            idx++;
            return maxK;
        }
    }
}
