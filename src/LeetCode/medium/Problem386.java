package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem386 {
    //https://leetcode.com/problems/lexicographical-numbers/
    public static void main(String[] args) {
        LeetCodeUtils.printList(lexicalOrder(50000));
        LeetCodeUtils.printList(lexicalOrder(13));
        LeetCodeUtils.printList(lexicalOrder(2));
        LeetCodeUtils.printList(lexicalOrder(1));
    }

    //5 min
    //Runtime
    //25 ms
    //Beats
    //18.64%
    //Memory
    //47.6 MB
    //Beats
    //50%
    static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        Collections.sort(list, (a, b) -> Integer.toString(a).compareTo(Integer.toString(b)));
        return list;
    }
}
