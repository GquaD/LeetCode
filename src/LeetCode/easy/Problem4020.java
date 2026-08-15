package LeetCode.easy;

public class Problem4020 {
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //45.00
    //MB
    //Beats
    //-%
    public int elevatorRequests(int n, int[] requests) {
        int sec = 0, last = 0;
        for (int f: requests) {
            sec += Math.abs(last - f);
            last = f;
        }

        return sec;
    }
}
