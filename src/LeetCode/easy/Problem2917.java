package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2917 {
    //https://leetcode.com/problems/find-the-k-or-of-an-array/
    public static void main(String[] args) {

    }

    //
    //10min
    //Runtime
    //12
    //ms
    //Beats
    //9.72%
    //Analyze Complexity
    //Memory
    //44.39
    //MB
    //Beats
    //19.79%
    static int findKOr(int[] nums, int k) {
        List<String> list = new ArrayList<>();
        for (int n : nums) list.add(Integer.toBinaryString(n));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (String s : list) {
                if (i < s.length() && s.charAt(s.length() - i - 1) == '1') {
                    count++;
                }
            }
            if (k <= count) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }
}
