package LeetCode.easy;

import java.util.Arrays;
import java.util.List;

public class Problem2859 {
    //https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/
    public static void main(String[] args) {
        System.out.println(sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2), 1));
    }

    //
    //10min
    //Runtime
    //3 ms
    //Beats
    //33.70%
    //Memory
    //43.6 MB
    //Beats
    //47.83%
    static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0, c = 0;
        for (int i = 0; i < nums.size(); i++) {
            String s = Integer.toBinaryString(i);
            for (int j = 0; j < s.length(); j++) if (s.charAt(j) == '1') c++;
            if (c == k) sum += nums.get(i);
            c = 0;
        }
        return sum;
    }
}
