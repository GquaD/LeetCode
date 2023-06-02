package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem1850 {
    //https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
    public static void main(String[] args) {

    }

    static int getMinSwaps(String num, int k) {
        TreeSet<String> set = new TreeSet<>();
        //add strings with shuffled last 2 numbers
        //then 3 number etc
        return 42;
    }

    static int getMinSwaps1(String num, int k) {
        List<Integer> list = new ArrayList<>();
        List<String> listGreater = new ArrayList<>();
        int count = 0, idx = num.length() - 1;
        while (count < k) {
            int curr = num.charAt(idx) - '0';
            list.add(curr);
            if (list.size() == 1) continue;
            for (int i = list.size() - 1; i > 0; i--) {

            }
        }
        return 42;
    }
}
