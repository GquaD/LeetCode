package LeetCode.easy;

public class Problem2264 {
    //https://leetcode.com/problems/largest-3-same-digit-number-in-string/
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("222"));
    }

    //https://leetcode.com/problems/largest-3-same-digit-number-in-string/solutions/3464816/java-using-stringbuilder/
    //5-10 min
    //Runtime
    //3 ms
    //Beats
    //62.18%
    //Memory
    //42.5 MB
    //Beats
    //32.77%
    static String largestGoodInteger(String num) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        char max = '0';
        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (num.charAt(i) >= max) {
                    max = num.charAt(i);
                    sb.setLength(0);
                    res = sb.append(max).append(max).append(max).toString();
                }
            }
        }
        return res;
    }
}
