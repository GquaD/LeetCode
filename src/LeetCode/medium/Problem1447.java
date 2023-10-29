package LeetCode.medium;

import LeetCode.LeetCodeUtils;
import javafx.util.Pair;

import java.util.*;

public class Problem1447 {
    //https://leetcode.com/problems/simplified-fractions/
    public static void main(String[] args) {
        LeetCodeUtils.printList(simplifiedFractions(2));
        LeetCodeUtils.printList(simplifiedFractions(1));
        LeetCodeUtils.printList(simplifiedFractions(3));
        LeetCodeUtils.printList(simplifiedFractions(4));
    }

    //https://leetcode.com/problems/simplified-fractions/solutions/4222517/java-using-greatest-common-divisor/
    //5-10min
    //Runtime
    //15 ms
    //Beats
    //95.68%
    //Memory
    //44.9 MB
    //Beats
    //9.88%
    static List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) return list;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    sb.append(j).append("/").append(i);
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        return list;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static Map<Interval, Set<Pair<Interval, Interval>>> map;

    static List<String> simplifiedFractions1(int n) {
        if (map == null) map = new HashMap<>();
        if (n == 1) return new ArrayList<>();
        fillTheMap();
        int temp = n;
        while (temp > 1) {

        }
        return null;
    }

    private static void fillTheMap() {
        for (int i = 2; i <= 100; i++) {

        }
    }
}
