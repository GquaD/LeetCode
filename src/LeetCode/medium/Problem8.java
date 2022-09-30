package LeetCode.medium;

public class Problem8 {
    //https://leetcode.com/problems/string-to-integer-atoi/

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("+12"));
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("   +0 123"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("-20000000000000000000"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("  +  413"));
    }

    //https://leetcode.com/problems/string-to-integer-atoi/solutions/2641352/java-solution/
    //Runtime 3 ms Beats 73.68%
    //Memory 42.1 MB Beats 93.21%
    static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean gotSign = false;
        boolean gotDigit = false;
        for (char c : s.toCharArray()) {
            if ((c == '-' || c == '+') && !gotSign && !gotDigit) {
                gotSign = true;
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                gotDigit = true;
                sb.append(c);
            } else if (c == ' ' && !gotDigit && !gotSign) {
                continue;
            } else break;
        }
        sb = checkForLeadingZeros(sb);
        if (sb.toString().equals("") || sb.toString().equals("-") || sb.toString().equals("+")) return 0;
        if (sb.length() > 12) sb.setLength(12);
        Long l = Long.parseLong(sb.toString());
        if (l >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return l.intValue();
    }

    private static StringBuilder checkForLeadingZeros(StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean leadingZero = true;
        for (char c : sb.toString().toCharArray()) {
            if (c == '0' && leadingZero) {
                continue;
            } else if (c == '-' || c == '+') {
                stringBuilder.append(c);
            } else {
                leadingZero = false;
                stringBuilder.append(c);
            }
        }
        return stringBuilder;
    }
}
