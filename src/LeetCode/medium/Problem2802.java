package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2802 {
    //https://leetcode.com/problems/find-the-k-th-lucky-number/
    public static void main(String[] args) {
        System.out.println(kthLuckyNumber(4));
        System.out.println(kthLuckyNumber(5));
    }

    //nnnn
    //Runtime
    //7
    //ms
    //Beats
    //72.22%
    //of users with Java
    //Memory
    //45.46
    //MB
    //Beats
    //5.56%
    //of users with Java
    static String kthLuckyNumber(int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            if (k % 2 == 1) sb.append('4');
            else sb.append('7');
            k = (k - 1) / 2;
        }
        return sb.reverse().toString();
    }

    //
    static List<Integer> list;
    static String kthLuckyNumber1(int k) {
        if (list == null) {
            list = new ArrayList<>();
            int n = 1, sum = 0;
            list.add(0);
            while (sum <= 1_000_000_000) {
                n *= 2;
                sum += n;
                list.add(sum);
            }
        }

        int idx = Collections.binarySearch(list, k);
        if (idx < 0) idx = -idx - 2;
        int diff = idx < 0 ? k : k - list.get(idx);

        StringBuilder sb = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            int pow = (int) Math.pow(2, i);
            if (diff / pow == 1 && diff % pow > 0) {
                sb.append('7');
            } else {
                sb.append('4');
            }
            diff -= pow + 1;
        }
        return sb.toString();
    }
}
