package LeetCode.easy;

public class Problem3884 {
    //1min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.68
    //MB
    //Beats
    //5.91%
    public int firstMatchingIndex(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) return i;
        }
        return -1;
    }
}
