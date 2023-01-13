package LeetCode.easy;

import java.time.LocalDate;

public class Problem1154 {
    //https://leetcode.com/problems/day-of-the-year/
    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));
        System.out.println(dayOfYear("2019-02-10"));
        System.out.println(dayOfYear("2020-12-31"));
        System.out.println(dayOfYear("2012-01-02"));
    }

    //https://leetcode.com/problems/day-of-the-year/solutions/3044247/java-not-using-library-o-1-solution/
    //Runtime
    //12 ms
    //Beats
    //85.39%
    //Memory
    //42.9 MB
    //Beats
    //72.75%
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    static {
        for (int i = 1; i < days.length; i++) days[i] += days[i - 1];
    }
    static int dayOfYear(String date) {
        String[] d = date.split("-");
        int year = Integer.parseInt(d[0]), month = Integer.parseInt(d[1]) - 1, day = Integer.parseInt(d[2]);
        return isLeapYear(year) && month > 1 ? days[month] + day + 1 : days[month] + day;
    }
    static boolean isLeapYear(long year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }
}
