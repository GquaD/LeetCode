package LeetCode.medium;

import java.util.*;

public class Problem1272 {
    //https://leetcode.com/problems/remove-interval/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/remove-interval/solutions/5377536/java-o-n-99-faster/
    //20-25min
    //Runtime
    //5
    //ms
    //Beats
    //99.17%
    //Analyze Complexity
    //Memory
    //54.68
    //MB
    //Beats
    //78.33%
    public List<List<Integer>> removeInterval(int[][] intervals, int[] t) {
        List<List<Integer>> list = new ArrayList<>();
        int l = t[0], r = t[1];
        for (int[] i : intervals) {
            int a = i[0], b = i[1];
            if (l <= a && b <= r) {
                continue;
            } if (b <= l || a >= r) {
                list.add(createList(a, b));
            } else if (a < l && b > l && b <= r) {
                list.add(createList(a, l));
            } else if (a < r && a >= l && b > r) {
                list.add(createList(r, b));
            } else {
                list.add(createList(a, l));
                list.add(createList(r, b));
            }
        }
        return list;
    }

    private List<Integer> createList(int a, int b) {
        List<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        return l;
    }
}
