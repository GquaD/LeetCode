package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem1281 {
    //https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    //Memory Usage: 41.1 MB, less than 31.07% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    static int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            prod *= digit;
            sum += digit;
            n /= 10;
        }
        return prod - sum;
    }

    //Runtime: 2 ms, faster than 5.27% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    //Memory Usage: 40.9 MB, less than 47.68% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    static int subtractProductAndSum1(int n) {
        List<Integer> digits = findDigits(n);
        int prod = 1;
        int sum = 0;
        for (int i = 0; i < digits.size(); i++) {
            prod *= digits.get(i);
            sum += digits.get(i);
        }
        return prod - sum;
    }

    private static List<Integer> findDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }
}
