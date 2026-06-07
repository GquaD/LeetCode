package LeetCode.easy;

public class Problem3950 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //42.70
    //MB
    //Beats
    //-%
    public boolean consecutiveSetBits(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') count++;
        return count == 1;
    }
}
