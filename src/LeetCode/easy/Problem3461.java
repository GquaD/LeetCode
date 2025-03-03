package LeetCode.easy;

public class Problem3461 {
    //https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //7
    //ms
    //Beats
    //86.47%
    //Analyze Complexity
    //Memory
    //43.25
    //MB
    //Beats
    //92.42%
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > 2) {
            for (int i = 0; i < s.length() - 1; i++) {
                sb.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
            }
            s = sb.toString();
            sb.setLength(0);
        }
        return s.charAt(0) == s.charAt(1);
    }
}
