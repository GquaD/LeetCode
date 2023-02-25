package LeetCode.easy;

import java.util.Arrays;

public class Problem434 {
    //https://leetcode.com/problems/number-of-segments-in-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-segments-in-a-string/solutions/3227223/java-100-faster-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.2 MB
    //Beats
    //39.3%

    static int countSegments(String s) {
        int count = 0, countSegments = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') count++;
            else {
                if (count > 0) countSegments++;
                count = 0;
            }
        }
        return count > 0 ? countSegments + 1 : countSegments;
    }

    //https://leetcode.com/problems/number-of-segments-in-a-string/solutions/3227224/java-one-line/
    //sam
    //5 min
    //Runtime
    //1 ms
    //Beats
    //36.96%
    //Memory
    //40.2 MB
    //Beats
    //39.3%
    static int countSegments1(String s) {
        return (int) Arrays.stream(s.trim().split(" ")).filter(t -> t.length() > 0).count();
    }
}
