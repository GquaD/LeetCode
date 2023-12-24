package LeetCode.easy;

public class Problem1758 {
    //https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
    //15min
    //Runtime
    //6 ms
    //Beats
    //17.5%
    //Memory
    //42.8 MB
    //Beats
    //5.57%

    static int minOperations(String s) {
        int count = 0, count1 = 0, len = s.length();
        char p = '0', p1 = len % 2 == 0 ? '0' : '1';

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != p) count++;
            p = p == '0' ? '1' : '0';

            if (s.charAt(len - i - 1) != p1) count1++;
            p1 = p1 == '0' ? '1' : '0';
        }

        return Math.min(count, count1);
    }

    static int minOperations1(String s) {
        int count = 0, len = s.length();
        char prev = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char cur = s.charAt(i);
            if (cur == prev) {
                count++;
                prev = cur == '0' ? '1' : '0';
            } else{
                prev = cur;
            }
        }
        int count1 = 0;
        prev = s.charAt(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == prev) {
                count1++;
                prev = cur == '0' ? '1' : '0';
            } else {
                prev = cur;
            }
        }
        return Math.min(count, count1);
    }
}
