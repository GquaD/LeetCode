package LeetCode.easy;

public class Problem2798 {
    //https://leetcode.com/problems/number-of-employees-who-met-the-target/
    public static void main(String[] args) {

    }

    //1 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41 MB
    //Beats
    //100%
    static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int h : hours) if (h >= target) count++;
        return count;
    }
}
