package LeetCode.easy;

public class Problem3921 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //47.16
    //MB
    //Beats
    //95.94%
    public int[] scoreValidator(String[] events) {
        int[] res = new int[2];

        for (String s: events) {
            calculate(s, res);
            if (res[1] >= 10) break;
        }
        return res;
    }

    private void calculate(String s, int[] res) {
        if (s.length() == 2) {
            res[0]++;
        } else {
            char c = s.charAt(0);
            if (c == 'W') res[1]++;
            else res[0] += c - '0';
        }
    }
}
