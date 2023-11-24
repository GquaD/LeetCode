package LeetCode.easy;

public class Problem2864 {
    //https://leetcode.com/problems/maximum-odd-binary-number/
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
        System.out.println(maximumOddBinaryNumber("0101"));
    }

    //https://leetcode.com/problems/maximum-odd-binary-number/solutions/4325583/java-o-n-solution/
    //3min
    //Runtime
    //2 ms
    //Beats
    //78.63%
    //Memory
    //42.9 MB
    //Beats
    //54.23%
    static String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count1 = 0, count0 = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '1') count1++;
        count0 = s.length() - count1--;
        sb.append('1');
        for (int i = 0; i < count0; i++) sb.append('0');
        for (int i = 0; i < count1; i++) sb.append('1');
        return sb.reverse().toString();
    }
}
