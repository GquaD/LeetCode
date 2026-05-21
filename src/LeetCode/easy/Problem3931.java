package LeetCode.easy;

public class Problem3931 {
    //1min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //43.47
    //MB
    //Beats
    //90.49%
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for (int i = 1; i < s.length(); i++) if (Math.abs(s.charAt(i - 1) - s.charAt(i)) > 2) return false;
        return true;
    }
}
