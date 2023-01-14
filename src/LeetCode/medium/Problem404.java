package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem404 {
    //https://leetcode.com/problems/queue-reconstruction-by-height/description/
    public static void main(String[] args) {
        LeetCodeUtils.print2DArray(reconstructQueue1(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));
    }

    //nnnn
    //Runtime
    //6 ms
    //Beats
    //91.92%
    //Memory
    //43 MB
    //Beats
    //82.82%
    static int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[list.size()][]);
    }

    static int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int[] p : people) {
            int h = p[0], k = p[1];
            List<Integer> list = map.get(h);
            if (list != null) {
                list.add(k);
            } else {
                list = new ArrayList<>();
                list.add(k);
                map.put(h, list);
            }
        }
        for (int h : map.keySet()) Collections.sort(map.get(h));

        List<Pair> list = new ArrayList<>();
        for (int h : map.keySet()) {
            List<Integer> ks = map.get(h);
            for (int k : ks) {
                Pair first = list.isEmpty() ? new Pair(h, k) : list.get(0);
                if (list.isEmpty()) {
                    list.add(first);
                } else if (h < first.h) {
                    list.add(0, new Pair(h, k));
                } else {
                    for (int i = k; i < list.size(); i++) {
                        Pair curr = list.get(i);
                        if (curr.h < h) {
                            list.add(i, new Pair(h, k));

                        }

                    }
                }
            }
        }
        return null;
    }

    static class Pair {
        int h, k;

        public Pair(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
}
