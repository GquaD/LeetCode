package LeetCode.medium;

public class Problem371 {
    //https://leetcode.com/problems/sum-of-two-integers/
    public static void main(String[] args) {
        System.out.println(getSum(2, 3));
        System.out.println(getSum(8, 3));
        System.out.println(getSum(-8, 3));
    }


    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.7 MB
    //Beats
    //20.5%

    static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    //does not work on negative numbers
    static int getSum1(int a, int b) {
        String sa = Integer.toBinaryString(a), sb = Integer.toBinaryString(b);
        String min = sa.length() < sb.length() ? sa : sb;
        String max = sa.length() < sb.length() ? sb : sa;
        StringBuilder stringBuilder = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < min.length(); i++) {
            char cMin = min.charAt(min.length() - i - 1);
            char cMax = max.charAt(max.length() - i - 1);
            if (cMax == cMin && cMax == '1') {
                if (temp == 0) {
                    stringBuilder.append(0);
                    temp = 1;
                } else {
                    stringBuilder.append(1);
                    temp = 1;
                }
            } else if (cMax == '0' && cMin == '1' || cMax == '1' && cMin == '0') {
                if (temp == 0) {
                    stringBuilder.append(1);
                } else {
                    stringBuilder.append(0);
                    temp = 1;
                }
            } else {
                stringBuilder.append(temp);
                temp = 0;
            }
        }

        for (int i = min.length(); i < max.length(); i++) {
            char c = max.charAt(max.length() - i - 1);
            if (c == '1' && temp == 1) {
                stringBuilder.append(0);
            } else if (c == '1') {
                stringBuilder.append(1);
            } else if (c == '0' && temp == 1) {
                stringBuilder.append(1);
                temp = 0;
            } else stringBuilder.append(0);
        }
        if (temp > 0) stringBuilder.append(1);
        String res = stringBuilder.reverse().toString();
        return Integer.parseInt(res, 2);
    }
}
