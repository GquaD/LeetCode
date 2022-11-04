package LeetCode.easy;

import java.util.Arrays;

public class Problem806 {
    //https://leetcode.com/problems/number-of-lines-to-write-string/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa")));
    }

    //https://leetcode.com/problems/number-of-lines-to-write-string/solutions/2776504/java-average-o-n-solution/
    //10-15 min with thinking
    //Runtime
    //2 ms
    //Beats
    //40.60%
    //Memory
    //42.9 MB
    //Beats
    //7%
    static int[] numberOfLines(int[] widths, String s) {
        int tempSum = 0, lineCounter = 1;
        for (char c : s.toCharArray()) {
            int currCharLen = widths[c - 'a'];
            if (tempSum + currCharLen <= 100) {
                tempSum += currCharLen;
            } else {
                lineCounter++;
                tempSum = currCharLen;
            }
        }
        return new int[]{lineCounter, tempSum};
    }
}
