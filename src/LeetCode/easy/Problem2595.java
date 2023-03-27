package LeetCode.easy;

public class Problem2595 {
    //https://leetcode.com/problems/number-of-even-and-odd-bits/


    //Runtime
    //2 ms
    //Beats
    //48.91%
    //Memory
    //42.4 MB
    //Beats
    //71.90%
    static int[] evenOddBit(int n) {
        String s = Integer.toBinaryString(n);
        int even = 0, odd = 0, count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count % 2 == 0 && s.charAt(i) == '1') even++;
            else if (count % 2 == 1 && s.charAt(i) == '1') odd++;
            count++;
        }
        return new int[]{even, odd};
    }
}
