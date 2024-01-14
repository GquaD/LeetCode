package LeetCode.medium;
import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem3006 {
    //https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/
    public static void main(String[] args) {
        LeetCodeUtils.printList(beautifulIndices("rinzbrrr", "nzb", "r", 2));
    }

    //https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/solutions/4565493/java-o-nlogn/
    //30 min
    //Runtime
    //29
    //ms
    //Beats
    //33.33%
    //of users with Java
    //Memory
    //47.90
    //MB
    //Beats
    //33.33%
    //of users with Java
    static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>(), res = new ArrayList<>();

        for (int i = 0; i <= s.length(); i++) {
            if (i + a.length() <= s.length()) {
                String a1 = s.substring(i, i + a.length());
                if (a1.equals(a)) list1.add(i);
            }

            if (i + b.length() <= s.length()) {
                String b1 = s.substring(i, i + b.length());
                if (b1.equals(b)) list2.add(i);
            }
        }

        if (list1.size() == 0 || list2.size() == 0) return res;

        for (int i : list1) {
            int i2 = Collections.binarySearch(list2, i);
            if (i2 < 0) i2 = -i2 - 1;
            if (i2 >= list2.size()) i2 = list2.size() - 1;

            if (Math.abs(i - list2.get(i2)) <= k || (i2 - 1 >= 0 && Math.abs(list2.get(i2 - 1) - i) <= k)) res.add(i);
        }
        return res;
    }
}
