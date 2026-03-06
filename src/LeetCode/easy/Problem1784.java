package LeetCode.easy;

public class Problem1784 {
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.01
    //MB
    //Beats
    //31.89%

    //https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solutions/7629947/java-100-faster-solution-by-tbekpro-xvyx/
    public boolean checkOnesSegment(String s) {
        int countSwitches = 0;
        for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) != s.charAt(i + 1)) countSwitches++;
        return countSwitches <= 1;
    }
}
