package LeetCode.hard;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem352 {
    //https://leetcode.com/problems/data-stream-as-disjoint-intervals/
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(6);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(0);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(4);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(8);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(7);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(6);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(4);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(7);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
        summaryRanges.addNum(5);
        System.out.println();
        LeetCodeUtils.print2DArray(summaryRanges.getIntervals());
    }

    //https://leetcode.com/problems/data-stream-as-disjoint-intervals/solutions/3109171/java-from-672ms-to-113ms-2-solutions/
    //5 min
    //Runtime
    //113 ms
    //Beats
    //37.39%
    //Memory
    //47.7 MB
    //Beats
    //49.58%
    static class SummaryRanges {
        TreeSet<Integer> set;
        public SummaryRanges() {
            set = new TreeSet<>();
        }

        public void addNum(int value) {
            set.add(value);
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();
            int temp = set.first();
            int[] arr = new int[2];
            arr[0] = temp;
            arr[1] = temp;
            list.add(arr);
            for (Integer n : set) {
                if (n == temp) continue;
                if (n - temp == 1) {
                    arr[1] = n;
                    temp = n;
                } else {
                    arr = new int[2];
                    arr[0] = n;
                    arr[1] = n;
                    list.add(arr);
                    temp = n;
                }
            }

            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    //
    //30 min
    //Runtime
    //672 ms
    //Beats
    //5.4%
    //Memory
    //104.3 MB
    //Beats
    //5.88%
    static class SummaryRanges1 {
        PriorityQueue<Integer> pq;
        PriorityQueue<Integer> pq2;
        Set<Integer> set;
        public SummaryRanges1() {
            pq = new PriorityQueue<>();
            pq2 = new PriorityQueue<>();
            set = new HashSet<>();
        }

        public void addNum(int value) {
            if (!set.contains(value)) {
                pq.add(value);
                set.add(value);
            }
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();
            int temp = pq.poll();
            pq2.offer(temp);
            int[] arr = new int[2];
            arr[0] = temp;
            arr[1] = temp;
            list.add(arr);
            while (!pq.isEmpty()) {
                int n = pq.poll();
                if (n - temp == 1) {
                    arr[1] = n;
                    temp = n;
                } else {
                    arr = new int[2];
                    arr[0] = n;
                    arr[1] = n;
                    list.add(arr);
                    temp = n;
                }
                pq2.offer(n);
            }
            pq = pq2;
            pq2 = new PriorityQueue<>();
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
