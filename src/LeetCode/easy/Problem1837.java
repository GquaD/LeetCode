package LeetCode.easy;

import java.util.Arrays;
import java.util.Collections;

public class Problem1837 {
    //https://leetcode.com/problems/sum-of-digits-in-base-k/
    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
        System.out.println(sumBase(9, 2));
        System.out.println(sumBase(10, 2));
        System.out.println(sumBase(10, 10));
    }

    //Runtime: 1 ms, faster than 14.00% of Java online submissions for Sum of Digits in Base K.
    //Memory Usage: 39.9 MB, less than 84.28% of Java online submissions for Sum of Digits in Base K.
    static int sumBase(int n, int k) {
        //convert
        //then sum digits
        String converted = convert(n, k);
        int sum = 0;
        for (int i = 0; i < converted.length(); i++) {
            sum += Integer.parseInt(converted.charAt(i) + "");
        }
        return sum;
    }

    private static String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }
        String s = sb.toString();
        sb.setLength(0);
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
