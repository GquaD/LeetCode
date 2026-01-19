package LeetCode.easy;

public class Problem3794 {
    //https://leetcode.com/problems/reverse-string-prefix/description/

    //1min
    //Runtime
    //2
    //ms
    //Beats
    //53.50%
    //Analyze Complexity
    //Memory
    //44.40
    //MB
    //Beats
    //98.26%
    public String reversePrefix(String s, int k) {
        return new StringBuilder(s.substring(0, k)).reverse().append(s.substring(k)).toString();
    }
}
