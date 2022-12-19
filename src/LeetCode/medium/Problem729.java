package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem729 {
    //https://leetcode.com/problems/my-calendar-i/description/
    public static void main(String[] args) {

    }

    //15 min
    //Runtime
    //259 ms
    //Beats
    //7.55%
    //Memory
    //55.1 MB
    //Beats
    //12.67%
    static class MyCalendar {
        List<List<Integer>> timeline;
        public MyCalendar() {
            timeline = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (List<Integer> interval : timeline) {
                if (interval.get(0) < end && interval.get(1) > start) {
                    return false;
                }
            }

            addInterval(start, end);
            return true;
        }

        private void addInterval(int start, int end) {
            List<Integer> interval = new ArrayList<>(2);
            interval.add(start);
            interval.add(end);
            timeline.add(interval);
        }
    }
}
