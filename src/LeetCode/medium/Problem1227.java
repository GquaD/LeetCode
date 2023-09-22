package LeetCode.medium;

public class Problem1227 {
    //https://leetcode.com/problems/airplane-seat-assignment-probability
    public static void main(String[] args) {

    }

    //2 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.2 MB
    //Beats
    //77.34%
    static double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}
