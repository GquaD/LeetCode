package LeetCode.medium;

public class Problem2582 {
    //https://leetcode.com/problems/pass-the-pillow/
    public static void main(String[] args) {

    }

    //5min
    //nnn for first line idea
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.15
    //MB
    //Beats
    //61.02%
    public int passThePillow(int n, int time) {
        time = time % (n * 2 - 2);
        if (time < n) {
            return time + 1;
        } else {
            return n - (time - n + 1);
        }
    }
}
