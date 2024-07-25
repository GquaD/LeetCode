package LeetCode.easy;

public class Problem3226 {


    //https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //22.55%
    //Analyze Complexity
    //Memory
    //41.15
    //MB
    //Beats
    //21.65%
    static int minChanges(int n, int k) {
        String a = Integer.toBinaryString(n), b = Integer.toBinaryString(k);
        if (a.length() > b.length()) {
            while (a.length() > b.length()) {
                b = "0".concat(b);
            }
        } else {
            while (b.length() > a.length()) {
                a = "0".concat(a);
            }
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i), d = b.charAt(i);
            if (c == '0' && d == '1') return -1;
            if (c == '1' && d == '0') count++;
        }
        return count;
    }
}
