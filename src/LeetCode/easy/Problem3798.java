package LeetCode.easy;

public class Problem3798 {
    //https://leetcode.com/problems/largest-even-number

    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.96
    //MB
    //Beats
    //86.05%
    public String largestEven(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '2') {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }
}
