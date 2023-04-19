package LeetCode.easy;

import java.util.*;

public class Problem1331 {
    //https://leetcode.com/problems/rank-transform-of-an-array/
    public static void main(String[] args) {

    }

    //5-10 min
    //Runtime
    //60 ms
    //Beats
    //19.44%
    //Memory
    //52.1 MB
    //Beats
    //97.70%
    static int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) set.add(n);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) arr[i] = Collections.binarySearch(list, arr[i]) + 1;
        return arr;
    }
}
