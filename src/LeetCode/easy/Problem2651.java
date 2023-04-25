package LeetCode.easy;

public class Problem2651 {
    //https://leetcode.com/problems/calculate-delayed-arrival-time/
    public static void main(String[] args) {

    }

    //
    //1 min
    //Runtime
    //1 ms
    //Beats
    //68.71%
    //Memory
    //40.4 MB
    //Beats
    //7.73%
    static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
