package LeetCode.easy;

public class Problem1118 {
    //https://leetcode.com/problems/number-of-days-in-a-month/


    //https://leetcode.com/problems/number-of-days-in-a-month/solutions/5563097/java-100-faster-o-1-solution/
    //3min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.22
    //MB
    //Beats
    //45.16%
    private static int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int numberOfDays(int year, int month) {
        if (month != 2)
            return months[month];
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return 29;
            } else if (year % 100 == 0) {
                return 28;
            }
            return 29;
        }
        return 28;
    }
}
