package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2384 {
    //https://leetcode.com/problems/largest-palindromic-number/
    public static void main(String[] args) {
        System.out.println(largestPalindromic("0660"));
        System.out.println(largestPalindromic("6006"));
        System.out.println(largestPalindromic("00000"));
        System.out.println(largestPalindromic("00100"));
        System.out.println(largestPalindromic("16159812615891956168165106010810601"));
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
    }

    //https://leetcode.com/problems/largest-palindromic-number/solutions/3549726/java-using-priorityqueues/
    //25-30 min
    //Runtime
    //144 ms
    //Beats
    //24.75%
    //Memory
    //45.5 MB
    //Beats
    //10.10%
    static String largestPalindromic(String num) {
        int[] digits = new int[10];
        for (int i = 0; i < num.length(); i++) digits[num.charAt(i) - '0']++;
        int countRest = 0;
        for (int i = 1; i < digits.length; i++) countRest += digits[i];
        if (countRest == 0) return "0";
        int highestSingleDigit = -1;
        PriorityQueue<Integer> pqIncr = new PriorityQueue<>(), pqDecr = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 1) highestSingleDigit = i;
            if (digits[i] > 0) {
                for (int j = 0; j < digits[i] / 2; j++) {
                    pqIncr.offer(i);
                    pqDecr.offer(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pqDecr.isEmpty()) sb.append(pqDecr.poll());
        sb.append(highestSingleDigit == -1 ? "" : highestSingleDigit);
        while (!pqIncr.isEmpty()) sb.append(pqIncr.poll());
        int startZero = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') break;
            startZero++;
        }
        String ans = sb.substring(startZero, sb.length() - startZero);
        return ans;
    }
}
