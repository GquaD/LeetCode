package LeetCode.easy;

public class Problem521 {
    //5min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //42.70
    //MB
    //Beats
    //38.85%
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
