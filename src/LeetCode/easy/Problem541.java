package LeetCode.easy;

public class Problem541 {
    //https://leetcode.com/problems/reverse-string-ii/
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 4));
        System.out.println(reverseStr("abcdefg", 2));
    }

    //https://leetcode.com/problems/reverse-string-ii/solutions/3116891/java-100-faster-solution/
    //10 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //69.24%
    static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while (s.length() >= 2 * k) {
            String temp = s.substring(0, k);
            sb.append(new StringBuilder(temp).reverse());
            sb.append(s.substring(k, 2 * k));
            s = s.substring(2 * k);
        }
        if (s.length() <= k) {
            sb.append(new StringBuilder(s).reverse());
        } else {
            sb.append(new StringBuilder(s.substring(0, k)).reverse());
            sb.append(s.substring(k));
        }
        return sb.toString();
    }
}
