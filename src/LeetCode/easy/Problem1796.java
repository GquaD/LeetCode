package LeetCode.easy;

public class Problem1796 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //96.68%
    //Memory
    //43.32
    //MB
    //Beats
    //70.48%
    public int secondHighest(String s) {
        int one = -1, two = -1, t = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') t = c - '0';

            if (t > one) {
                two = one;
                one = t;
            } else if (t != one && t > two) {
                two = t;
            }
        }
        return two;
    }
}
