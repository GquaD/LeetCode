package LeetCode.easy;

public class Problem693 {
    //https://leetcode.com/problems/binary-number-with-alternating-bits/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-number-with-alternating-bits/solutions/3429039/java-3-line-100-faster-solution/
    //2 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.4 MB
    //Beats
    //67.31%
    static boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == s.charAt(i + 1)) return false;
        return true;
    }
}
