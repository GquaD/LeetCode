package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem1182 {
    //https://leetcode.com/problems/shortest-distance-to-target-color/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/shortest-distance-to-target-color/solutions/5765527/java-o-nlogn-solution/
    //20min
    //Runtime
    //148
    //ms
    //Beats
    //6.10%
    //Analyze Complexity
    //Memory
    //72.32
    //MB
    //Beats
    //41.46%
    static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer> one = new TreeSet<>(), two = new TreeSet<>(), three = new TreeSet<>();
        for (int i = 0; i < colors.length; i++) {
            int val = colors[i];
            if (val == 1) one.add(i);
            else if (val == 2) two.add(i);
            else three.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], c = queries[i][1];
            if (c == 1) {
                if (one.size() == 0) {
                    list.add(-1);
                } else if (one.size() == 1) {
                    list.add(Math.abs(one.last() - idx));
                } else {
                    int first = one.first(), last = one.last();
                    if (idx <= first) {
                        list.add(first - idx);
                        continue;
                    }
                    if (idx >= last) {
                        list.add(idx - last);
                        continue;
                    }
                    int l = one.floor(idx), r = one.ceiling(idx);
                    list.add(Math.min(r - idx, idx - l));
                }
            } else if (c == 2) {
                if (two.size() == 0) {
                    list.add(-1);
                } else if (two.size() == 1) {
                    list.add(Math.abs(two.last() - idx));
                } else {
                    int first = two.first(), last = two.last();
                    if (idx <= first) {
                        list.add(first - idx);
                        continue;
                    }
                    if (idx >= last) {
                        list.add(idx - last);
                        continue;
                    }
                    int l = two.floor(idx), r = two.ceiling(idx);
                    list.add(Math.min(r - idx, idx - l));
                }
            } else {
                if (three.size() == 0) {
                    list.add(-1);
                } else if (three.size() == 1) {
                    list.add(Math.abs(three.last() - idx));
                } else {
                    int first = three.first(), last = three.last();
                    if (idx <= first) {
                        list.add(first - idx);
                        continue;
                    }
                    if (idx >= last) {
                        list.add(idx - last);
                        continue;
                    }
                    int l = three.floor(idx), r = three.ceiling(idx);
                    list.add(Math.min(r - idx, idx - l));
                }
            }
        }
        return list;
    }
}
