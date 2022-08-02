package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1200 {
    //https://leetcode.com/problems/minimum-absolute-difference/
    public static void main(String[] args) {
        List<List<Integer>> list = minimumAbsDifference(new int[]{4,2,1,3});
        for (int i = 0; i < list.size(); i++) {
            LeetCodeUtils.printList(list.get(i));
        }
        System.out.println();
        list = minimumAbsDifference(new int[]{1,3,6,10,15});
        for (int i = 0; i < list.size(); i++) {
            LeetCodeUtils.printList(list.get(i));
        }
        System.out.println();
        list = minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27});
        for (int i = 0; i < list.size(); i++) {
            LeetCodeUtils.printList(list.get(i));
        }
        System.out.println();
    }

    //Runtime: 26 ms, faster than 50.17% of Java online submissions for Minimum Absolute Difference.
    //Memory Usage: 61.5 MB, less than 64.20% of Java online submissions for Minimum Absolute Difference.
    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (minDiff > diff) {
                minDiff = diff;
                list = new ArrayList<>();
            }
            if (diff == minDiff) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                list.add(pair);
            }
        }
        return list;
    }
}
