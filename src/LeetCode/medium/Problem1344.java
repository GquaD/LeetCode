package LeetCode.medium;

public class Problem1344 {
    //https://leetcode.com/problems/angle-between-hands-of-a-clock/
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(2, 45));
    }

    //https://leetcode.com/problems/angle-between-hands-of-a-clock/solutions/4276140/java-3-lines-100-faster-o-1-math-solution/
    //15min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.9 MB
    //Beats
    //6.67%
    static double angleClock(int hour, int minutes) {
        double h = 30 * hour + 0.5 * minutes, m = (minutes / 60.0) * 360;
        double diff = Math.abs(h - m);
        return Math.min(360.0 - diff, diff);
    }
}
