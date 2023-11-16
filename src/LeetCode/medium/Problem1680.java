package LeetCode.medium;

public class Problem1680 {
    //https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(24));
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(4));
    }

    //nnnn
    //Runtime
    //179 ms
    //Beats
    //35.18%
    //Memory
    //40 MB
    //Beats
    //37.4%
    static int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t > 0) {
                t /= 2;
                res *= 2;
            }
            res = (res + i) % 1_000_000_007;
        }
        return (int) res;
    }

    static int concatenatedBinary1(int n) {
        StringBuilder sb = new StringBuilder();
        long temp = 0;
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
            if (sb.length() > 63) {
                String s = sb.substring(sb.length() - 63, sb.length());
                sb.setLength(0);
                sb.append(s);
//                temp += Long.parseLong(sb.toString(), 2);
//                temp %= 1_000_000_007;
//                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            temp += Long.parseLong(sb.toString(), 2);
            temp %= 1_000_000_007;
        }
        return (int) temp;
    }
}
