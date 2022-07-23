package LeetCode;

import java.util.Arrays;

public class Problem1304 {
    //https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(9)));
        System.out.println(Arrays.toString(sumZero(1)));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
    //Memory Usage: 42.3 MB, less than 54.11% of Java online submissions for Find N Unique Integers Sum up to Zero.
    static int[] sumZero(int n) {
        int[] result = new int[n];
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            result[i] = -i - 1;
            result[result.length - 1 - i] = i + 1;
        }
        if (n % 2 == 1) {
            result[half] = 0;
        }
        return result;
    }
}
