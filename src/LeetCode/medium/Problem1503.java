package LeetCode.medium;

import java.util.*;

public class Problem1503 {
    //https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank
    public static void main(String[] args) {
        System.out.println(getLastMoment(27, new int[]{12}, new int[]{6,7}));
        System.out.println(getLastMoment(12, new int[]{7,1}, new int[]{12,11}));
        System.out.println(getLastMoment(4, new int[]{4,3,2}, new int[]{0,1}));
        System.out.println(getLastMoment(11, new int[]{1,4,5,10,9}, new int[]{2,7,6,3}));
        System.out.println(getLastMoment(1000, new int[]{0}, new int[]{}));
        System.out.println(getLastMoment(8, new int[]{3,5}, new int[]{4}));
        System.out.println(getLastMoment(4, new int[]{2}, new int[]{1}));
        System.out.println(getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
        System.out.println(getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7}));
        System.out.println(getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{}));
    }

    //
    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43.4 MB
    //Beats
    //94.51%
    static int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int l : left) res = Math.max(res, l);
        for (int r : right) res = Math.max(res, n - r);
        return res;
    }

    //Wrong Answer
    //159 / 167 testcases passed
    static int getLastMoment1(int n, int[] left, int[] right) {
        TreeSet<Integer> setLeft = new TreeSet<>();
        for (int l : left) setLeft.add(l);
        TreeSet<Integer> setRight = new TreeSet<>(Comparator.reverseOrder());
        for (int r : right) setRight.add(r);
        if (left.length == 0) return n - setRight.pollLast();
        if (right.length == 0) return setLeft.pollLast();

        int res = 0;
        Set<Integer> used = new HashSet<>();
        for (int r : setRight) {
            int temp = r;
            Integer l = setLeft.ceiling(r);
            while (used.contains(l)) l = setLeft.ceiling(++temp);
            if (l != null) {
                double mid = (r + l) / 2.0;
                res = Math.max(res, (int) Math.max(mid - r + mid, l - mid + n - mid));
                used.add(l);
                used.add(r);
            }
        }

        if (res == 0) {
            for (int l : left) res = Math.max(res, l);
            for (int r : right) res = Math.max(res, n - r);
        }
        return res;
    }
}
