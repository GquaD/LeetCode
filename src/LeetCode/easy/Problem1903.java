package LeetCode.easy;

public class Problem1903 {
    //https://leetcode.com/problems/largest-odd-number-in-string/description
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/largest-odd-number-in-string/solutions/4374759/java-o-n-2-lines-solution/
    //2 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //44.2 MB
    //Beats
    //82.59%
    static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--)
            if ((num.charAt(i) - '0') % 2 == 1)
                return num.substring(0, i + 1);
        return "";
    }
}
