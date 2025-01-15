package LeetCode.medium;

public class Problem2429 {
    //https://leetcode.com/problems/minimize-xor
    public static void main(String[] args) {
        System.out.println(minimizeXor(3, 5));
        System.out.println(minimizeXor(1, 12));
    }

    //https://leetcode.com/problems/minimize-xor/solutions/6284141/java-2ms-solution-by-tbekpro-g378/
    //15-20min
    //Runtime
    //2
    //ms
    //Beats
    //9.43%
    //Analyze Complexity
    //Memory
    //40.62
    //MB
    //Beats
    //46.23%
    static int minimizeXor(int num1, int num2) {
        Integer bits1 = Integer.bitCount(num1), bits2 = Integer.bitCount(num2);
        StringBuilder sb = new StringBuilder();
        if (bits2 >= bits1) {
            String x = Integer.toBinaryString(num1);
            int b = bits2 - bits1;
            for (int i = x.length() - 1; i >= 0; i--) {
                if (x.charAt(i) == '0') {
                    if (b > 0) {
                        b--;
                        sb.append('1');
                    } else {
                        sb.append(x.charAt(i));
                    }
                } else {
                    sb.append(x.charAt(i));
                }
            }
            while (b > 0) {
                sb.append('1');
                b--;
            }
            return Integer.parseInt(sb.reverse().toString(), 2);
        } else {
            String s1 = Integer.toBinaryString(num1);
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (c == '1') {
                    if (bits2 > 0) {
                        sb.append('1');
                        bits2--;
                    } else {
                        sb.append('0');
                    }
                } else sb.append('0');
            }
            return Integer.parseInt(sb.toString(), 2);
        }
    }
}
