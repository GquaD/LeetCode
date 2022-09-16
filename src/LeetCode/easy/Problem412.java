package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem412 {
    //https://leetcode.com/problems/fizz-buzz/
    public static void main(String[] args) {
        LeetCodeUtils.printList(fizzBuzz(3));
        LeetCodeUtils.printList(fizzBuzz(5));
        LeetCodeUtils.printList(fizzBuzz(15));
    }


    //Runtime: 2 ms, faster than 75.27% of Java online submissions for Fizz Buzz.
    //Memory Usage: 48.2 MB, less than 67.86% of Java online submissions for Fizz Buzz.
    static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add("" + i);
            }
        }
        return list;
    }
}
