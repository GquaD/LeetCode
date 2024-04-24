package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1213 {
    //https://leetcode.com/problems/intersection-of-three-sorted-arrays/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //4
    //ms
    //Beats
    //29.92%
    //of users with Java
    //Memory
    //44.98
    //MB
    //Beats
    //15.49%
    //of users with Java
    static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Set<Integer> set2 = new HashSet<>(), set3 = new HashSet<>();

        for (int n : arr2) set2.add(n);
        for (int n : arr3) set3.add(n);

        List<Integer> res = new ArrayList<>();
        for (int n : arr1) if (set2.contains(n) && set3.contains(n)) res.add(n);
        return res;
    }
}
