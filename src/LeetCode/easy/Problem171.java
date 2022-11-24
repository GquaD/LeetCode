package LeetCode.easy;

public class Problem171 {
    //https://leetcode.com/problems/excel-sheet-column-number/
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

    //https://leetcode.com/problems/excel-sheet-column-number/solutions/2844270/java-just-in-2ms/
    //Runtime
    //2 ms
    //Beats
    //81.4%
    //Memory
    //42.6 MB
    //Beats
    //59.46%
    static int titleToNumber(String s) {
        if (s.length() == 1) return s.charAt(0) - 'A' + 1;
        int pow = 1, sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sum += (c - 'A' + 1) * pow;
            pow *= 26;
        }
        return sum;
    }
}
