package LeetCode.easy;

public class Problem3986 {
    //1min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //44.32
    //MB
    //Beats
    //84.21%
    //https://leetcode.com/problems/number-of-elapsed-seconds-between-two-times/solutions/8396919/java-o1-solution-by-tbekpro-3v8n/
    public int secondsBetweenTimes(String s, String e) {
        int h = (e.charAt(0) - '0') * 10 + e.charAt(1) - ((s.charAt(0) - '0') * 10 + s.charAt(1));
        int m = (e.charAt(3) - '0') * 10 + e.charAt(4) - ((s.charAt(3) - '0') * 10 + s.charAt(4));
        int sec = (e.charAt(6) - '0') * 10 + e.charAt(7) - ((s.charAt(6) - '0') * 10 + s.charAt(7));
        return h * 3600 + m * 60 + sec;
    }
}
