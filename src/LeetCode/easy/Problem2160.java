package LeetCode.easy;

import java.util.Arrays;

public class Problem2160 {
    //https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
    public static void main(String[] args) {
        System.out.println(minimumSum(5432));
        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
        System.out.println(minimumSum(1100));
    }

    public static int minimumSum(int num) {
        //split to digits
        int[] digits = new int[4];
        digits[0] = num / 1000;
        digits[1] = (num - digits[0] * 1000) / 100;
        int d2Number = (num - (digits[0] * 1000 + digits[1] * 100));
        digits[2] = d2Number / 10;
        digits[3] = d2Number % 10;

        //build smallest pair
        Arrays.sort(digits);
        int first = digits[0] * 10 + digits[2];
        int second = digits[1] * 10 + digits[3];

        //return result
        return first + second;
    }
}
