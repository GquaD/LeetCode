package LeetCode.easy;

public class Problem191 {
    //https://leetcode.com/problems/number-of-1-bits/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 87.14% of Java online submissions for Number of 1 Bits.
    //Memory Usage: 41.8 MB, less than 11.84% of Java online submissions for Number of 1 Bits.
    static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
