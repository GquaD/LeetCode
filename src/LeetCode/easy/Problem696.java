package LeetCode.easy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Problem696 {
    //https://leetcode.com/problems/count-binary-substrings/
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("1"));
    }

    //https://leetcode.com/problems/count-binary-substrings/solutions/3801939/java-23ms-to-12ms-o-n-2-solutions/
    //5-10min
    //Runtime
    //12 ms
    //Beats
    //88.24%
    //Memory
    //44.2 MB
    //Beats
    //67.59%
    static int countBinarySubstrings(String s) {
        int sum = 0, zeros = 0, ones = 0;
        char prev = s.charAt(0);

        if (prev == '1') ones++;
        else zeros++;
        boolean firstTime = true;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                if (firstTime) {
                    firstTime = false;
                } else {
                    sum += Math.min(zeros, ones);
                    if (prev == '1') zeros = 0;
                    else ones = 0;
                }
            }
            if (curr == '1') ones++;
            else zeros++;

            prev = curr;
        }
        sum += Math.min(zeros, ones);
        return sum;
    }

    //
    //10-15min
    //Runtime
    //23 ms
    //Beats
    //5.66%
    //Memory
    //45 MB
    //Beats
    //6.10%
    static int countBinarySubstrings3(String s) {
        int sum = 0, zeros = 0, ones = 0;
        char prev = s.charAt(0);
        if (prev == '1') ones++;
        else zeros++;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                if (prev == '1') {
                    list.add(new Pair<>(1, ones));
                    ones = 0;
                } else {
                    list.add(new Pair<>(0, zeros));
                    zeros = 0;
                }
            }
            if (curr == '1') {
                ones++;
            } else {
                zeros++;
            }
            prev = curr;
        }

        list.add(prev == '1' ? new Pair<>(1, ones) : new Pair<>(0, zeros));
        for (int i = 1; i < list.size(); i++) {
            Pair<Integer, Integer> p1 = list.get(i - 1), p2 = list.get(i);
            sum += Math.min(p1.getValue(), p2.getValue());
        }
        return sum;
    }

    static int countBinarySubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int zeros = 0, ones = 0, idx = i;
            while (idx < s.length()) {
                if (s.charAt(idx++) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int countBinarySubstrings1(String s) {
        int count = 0, change = 0;
        for (int i = 0; i < s.length(); i++) {
            char prev = s.charAt(i);
            int idx = i + 1, countZeros = 1;
            while (idx < s.length()) {
                if (prev == s.charAt(idx)) {
                    if (change == 0) {
                        countZeros++;
                    } else {
                        countZeros--;
                    }
                } else if (change == 0) {
                    prev = s.charAt(idx);
                    countZeros--;
                    change++;
                } else {
                    change = 0;
                    break;
                }
                idx++;
            }
            if (countZeros == 0) count++;
        }
        return count;
    }
}
