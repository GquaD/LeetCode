package LeetCode.easy;

public class Problem4070 {
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //6.25%
    //Memory
    //42.85
    //MB
    //Beats
    //99.66%
    public int minRotations(String s) {
        int result = 0, pos = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0', diff = Math.min(Math.abs(pos - cur), Math.min(pos, cur) + 10 - Math.max(pos, cur));
            result += diff;
            pos = cur;
        }

        return result;
    }
}
