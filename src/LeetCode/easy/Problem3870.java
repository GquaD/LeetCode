package LeetCode.easy;

public class Problem3870 {
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //-%
    //Memory
    //42.83
    //MB
    //Beats
    //100.00%
    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 999;
    }
}
