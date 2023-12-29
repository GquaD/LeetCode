package LeetCode.medium;

import java.util.*;

public class Problem2100 {
    //https://leetcode.com/problems/find-good-days-to-rob-the-bank/
    public static void main(String[] args) {

    }

    //nnnn (just idea, wrote code myself)
    //Runtime
    //11 ms
    //Beats
    //8.18%
    //Memory
    //58.3 MB
    //Beats
    //35.45%
    static List<Integer> goodDaysToRobBank(int[] s, int time) {
        List<Integer> list = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < s.length; i++) list.add(i);
            return list;
        }
        int[] asc = new int[s.length];
        int prev = s[s.length - 1];
        for (int i = s.length - 2; i >= 0; i--) {
            if (prev >= s[i]) {
                asc[i] = asc[i + 1] + 1;
            }
            prev = s[i];
        }

        int[] desc = new int[s.length];
        prev = s[0];
        for (int i = 1; i < s.length; i++) {
            if (prev >= s[i]) {
                desc[i] = desc[i - 1] + 1;
            }
            prev = s[i];
        }

        for (int i = 0; i < s.length; i++) {
            if (asc[i] >= time && desc[i] >= time) {
                list.add(i);
            }
        }

        return list;
    }

    //This Question is same as 2420. Find All Good Indices on leetcode. :)

    //all tests passed but took too long
    static List<Integer> goodDaysToRobBank1(int[] s, int time) {
        List<Integer> list = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < s.length; i++) list.add(i);
            return list;
        }
        for (int i = time; i < s.length - time; i++) {
            int prev = s[i];
            boolean isAsc = true;
            for (int t = i + 1; t <= i + time; t++) {
                if (prev > s[t]) {
                    isAsc = false;
                    break;
                }
                prev = s[t];
            }
            if (isAsc) {
                boolean isDesc = true;
                int pre = s[i];
                for (int t = i - 1; t >= i - time; t--) {
                    if (pre > s[t]) {
                        isDesc = false;
                        break;
                    }
                    pre = s[t];
                }
                if (isDesc) list.add(i);
            }
        }
        return list;
    }
}
