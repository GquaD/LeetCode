package LeetCode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem295 {
    //https://leetcode.com/problems/find-median-from-data-stream/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-median-from-data-stream/solutions/2805210/java-solution/
    //10 mins
    //Runtime
    //349 ms
    //Beats
    //10.55%
    //Memory
    //70.5 MB
    //Beats
    //91.45%
    static class MedianFinder {
        List<Integer> list;
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            int idx = Collections.binarySearch(list, num);
            if (idx < 0) {
                list.add(-idx - 1, num);
            } else {
                list.add(idx, num);
            }
        }

        public double findMedian() {
            int half = list.size() / 2;
            if (list.size() % 2 == 0) {
                return (list.get(half) + list.get(half - 1)) * 1.0 / 2;
            } else {
                return list.get(half) * 1.0;
            }
        }
    }
}
