package LeetCode;

import java.util.Arrays;

public class Problem338 {
    //https://leetcode.com/problems/counting-bits/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(10)));
    }

    //Runtime: 16 ms, faster than 13.36% of Java online submissions for Counting Bits.
    //Memory Usage: 53.5 MB, less than 5.02% of Java online submissions for Counting Bits.
    static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            String temp = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
