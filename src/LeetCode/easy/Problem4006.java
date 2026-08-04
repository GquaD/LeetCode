package LeetCode.easy;

public class Problem4006 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //43.67
    //MB
    //Beats
    //92.40%
    public int countValidPrefixes(String s) {
        int zeros = 0, ones = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zeros++;
            else ones++;
            if (Math.abs(zeros - ones) <= 1) count++;
        }

        return count;
    }
}
