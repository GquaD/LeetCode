package LeetCode.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Problem712 {
    //https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
    public static void main(String[] args) {

    }

    //nnnnn
    //Runtime
    //570 ms
    //Beats
    //5.28%
    //Memory
    //68.6 MB
    //Beats
    //5.6%
    static Map<Pair<Integer, Integer>, Integer> map;

    static int minimumDeleteSum(String s1, String s2) {
        map = new HashMap<>();
        return calculateCost(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private static int calculateCost(String s1, String s2, int i, int j) {
        if (i < 0 && j < 0) return 0;

        Pair<Integer, Integer> p = new Pair<>(i, j);
        if (map.containsKey(p)) return map.get(p);

        if (i < 0) {
            map.put(p, s2.charAt(j) + calculateCost(s1, s2, i, j - 1));
            return map.get(p);
        }

        if (j < 0) {
            map.put(p, s1.charAt(i) + calculateCost(s1, s2, i - 1, j));
            return map.get(p);
        }

        if (s1.charAt(i) != s2.charAt(j)) {
            int a = s1.charAt(i) + calculateCost(s1, s2, i - 1, j), b = s2.charAt(j) + calculateCost(s1, s2, i, j - 1);
            map.put(p, Math.min(a, b));
        } else {
            map.put(p, calculateCost(s1, s2, i - 1, j - 1));
        }
        return map.get(p);
    }

    //Time Limit Exceeded
    //15 / 93
    static int minimumDeleteSum1(String s1, String s2) {
        return calculateCost1(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private static int calculateCost1(String s1, String s2, int i, int j) {
        if (i < 0) {
            int deleteCost = 0;
            for (int k = 0; k <= j; k++) deleteCost += s2.charAt(k);
            return deleteCost;
        }

        if (j < 0) {
            int deleteCost = 0;
            for (int k = 0; k <= i; k++) deleteCost += s1.charAt(k);
            return deleteCost;
        }

        if (s1.charAt(i) != s2.charAt(j)) {
            int a = s1.charAt(i) + calculateCost1(s1, s2, i - 1, j);
            int b = s2.charAt(j) + calculateCost1(s1, s2, i, j - 1);
            int c = s1.charAt(i) + s2.charAt(j) + calculateCost1(s1, s2, i - 1, j - 1);
            return Math.min(a, Math.min(b, c));
        } else {
            return calculateCost1(s1, s2, i - 1, j - 1);
        }
    }
}
