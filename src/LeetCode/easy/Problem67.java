package LeetCode.easy;

public class Problem67 {
    //https://leetcode.com/problems/add-binary/

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("111", "11"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1000001010", "1011"));
        System.out.println(addBinary("110010", "10111"));
    }

    //https://leetcode.com/problems/add-binary/solutions/2680563/java-straightforward-solution-o-n/
    //20-30 mins
    //Runtime
    //7 ms
    //Beats
    //27.70%
    //Memory
    //42.4 MB
    //Beats
    //77.97%
    static String addBinary(String a, String b) {
        String min = a.length() >= b.length() ? b : a;
        String max = a.length() >= b.length() ? a : b;
        StringBuilder sb = new StringBuilder();
        int memo = 0;
        for (int i = 0; i < min.length(); i++) {
            char ca = max.charAt(max.length() - i - 1), ba = min.charAt(min.length() - i - 1);
            if (memo == 1) {
                if (ca == '1' && ba == '1') {
                    sb.append('1');
                } else if (ca == '0' && ba == '0') {
                    sb.append('1');
                    memo = 0;
                } else {
                    sb.append('0');
                }
            } else {
                if (ca == '1' && ba == '1') {
                    sb.append('0');
                    memo = 1;
                } else if (ca == '0' && ba == '0') {
                    sb.append('0');
                } else sb.append('1');
            }
        }

        for (int i = min.length(); i < max.length(); i++) {
            char c = max.charAt(max.length() - i - 1);
            if (memo == 1) {
                if (c == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    memo = 0;
                }
            } else {
                sb.append(c);
            }
        }

        if (memo == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }


    static String addBinary0(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(a.length(), b.length());
        int memo = 0;
        for (int i = 0; i < len; i++) {
            char ca = a.charAt(len - i), ba = b.charAt(i);
            if (memo == 1) {
                if (ca == '1' && ba == '1') {
                    sb.append('1');
                    memo = 1;
                } else if (ca == '0' && ba == '0') {
                    sb.append('1');
                    memo = 0;
                } else {
                    sb.append('0');
                    memo = 0;
                }
            } else {
                if (ca == '1' && ba == '1') {
                    sb.append('0');
                    memo = 1;
                } else if (ca == '0' && ba == '0') {
                    sb.append('0');
                } else sb.append('1');
            }
        }

        int lenMax = Math.max(a.length(), b.length());
        String s = a.length() >= b.length() ? a : b;
        for (int i = len; i < lenMax; i++) {
            int c = s.charAt(i);
            if (memo == 1) {
                if (c == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    memo = 0;
                }
            } else {
                sb.append(c);
            }
        }

        if (memo == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
