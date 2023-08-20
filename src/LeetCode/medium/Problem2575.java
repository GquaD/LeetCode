package LeetCode.medium;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem2575 {
    //https://leetcode.com/problems/find-the-divisibility-array-of-a-string/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divisibilityArray("998244353", 3)));
        System.out.println(Arrays.toString(divisibilityArray("1010", 10)));
    }

    //https://leetcode.com/problems/find-the-divisibility-array-of-a-string/solutions/3938310/java-92-faster-remainder-tracker-math-solution/
    //30min
    //Runtime
    //7 ms
    //Beats
    //92.41%
    //Memory
    //56.8 MB
    //Beats
    //13.92%
    static int[] divisibilityArray(String word, int m) {
        int[] arr = new int[word.length()];
        long rem = 0;
        for (int i = 0; i < word.length(); i++) {
            rem = (rem * 10 + (word.charAt(i) - '0')) % m;
            if (rem == 0) arr[i] = 1;
        }
        return arr;
    }

    //Time Limit Exceeded
    //31 / 51
    static int[] divisibilityArray1(String word, int m) {
        //sb
        int[] arr = new int[word.length()];
        BigInteger div = new BigInteger(m + "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            BigInteger integer = new BigInteger(sb.toString());
            if (integer.remainder(div).compareTo(BigInteger.ZERO) == 0) arr[i] = 1;
        }
        return arr;
    }
}
