package LeetCode.easy;

import java.util.*;

public class Problem942 {
    //https://leetcode.com/problems/di-string-match/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }

    //Runtime: 4 ms, faster than 38.81% of Java online submissions for DI String Match.
    //Memory Usage: 48.1 MB, less than 70.77% of Java online submissions for DI String Match.
    static int[] diStringMatch(String s) {
        int max = s.length(), min = 0;
        int[] res = new int[max + 1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[res.length - 1] = max;
        return res;
    }

    //Runtime: 13 ms, faster than 5.28% of Java online submissions for DI String Match.
    //Memory Usage: 50.4 MB, less than 5.38% of Java online submissions for DI String Match.
    static int[] diStringMatch2(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= s.length(); i++) {
            list.add(i);
        }
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length - 1; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = list.getFirst();
                list.remove(0);
            } else {
                res[i] = list.getLast();
                list.remove(list.size() - 1);
            }
        }
        res[res.length - 1] = list.getFirst();
        return res;
    }

    static int[] diStringMatch1(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i + 1] = res[i] + 1;
            } else {
                res[i + 1] = res[i] - 1;
            }
        }
        int min = res[0];
        for (int i = 1; i < res.length; i++) {
            if (min > res[i]) {
                min = res[i];
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] += Math.abs(0 - min);
        }
        return res;
    }
}
