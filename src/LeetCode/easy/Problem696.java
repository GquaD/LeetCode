package LeetCode.easy;

public class Problem696 {
    //https://leetcode.com/problems/count-binary-substrings/
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("1"));
    }

    static int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int zeros = 0, ones = 0, idx = i;
            while (idx < s.length()) {
                if (s.charAt(idx++) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int countBinarySubstrings1(String s) {
        int count = 0, change = 0;
        for (int i = 0; i < s.length(); i++) {
            char prev = s.charAt(i);
            int idx = i + 1, countZeros = 1;
            while (idx < s.length()) {
                if (prev == s.charAt(idx)) {
                    if (change == 0) {
                        countZeros++;
                    } else {
                        countZeros--;
                    }
                } else if (change == 0) {
                    prev = s.charAt(idx);
                    countZeros--;
                    change++;
                } else {
                    change = 0;
                    break;
                }
                idx++;
            }
            if (countZeros == 0) count++;
        }
        return count;
    }
}
