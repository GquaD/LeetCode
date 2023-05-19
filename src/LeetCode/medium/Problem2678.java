package LeetCode.medium;

import java.util.Arrays;

public class Problem2678 {
    //https://leetcode.com/problems/number-of-senior-citizens/
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
    }

    //https://leetcode.com/problems/number-of-senior-citizens/solutions/3542185/java-100-faster-3-line-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.9 MB
    //Beats
    //95.67%
    static int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) count += (s.charAt(11) - '0') * 10 + (s.charAt(12) - '0') > 60 ? 1 : 0;
        return count;
    }

    static int countSeniors2(String[] details) {
        return Arrays.stream(details).filter(s -> Integer.parseInt(s.substring(11,13)) > 60).toArray().length;
    }

    //2 min
    //Runtime
    //1 ms
    //Beats
    //85.13%
    //Memory
    //41.5 MB
    //Beats
    //99.94%
    static int countSeniors1(String[] details) {
        int count = 0;
        for (String s : details) count += Integer.parseInt(s.substring(11,13)) > 60 ? 1 : 0;
        return count;
    }
}
