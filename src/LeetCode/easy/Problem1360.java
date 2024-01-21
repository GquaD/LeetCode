package LeetCode.easy;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Problem1360 {
    //https://leetcode.com/problems/number-of-days-between-two-dates/
    public static void main(String[] args) {
        System.out.println(daysBetweenDates("2015-06-29", "2019-06-30"));
    }

    //5min
    //Runtime
    //6
    //ms
    //Beats
    //37.04%
    //of users with Java
    //Memory
    //41.79
    //MB
    //Beats
    //18.52%
    //of users with Java
    static int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1), d2 = LocalDate.parse(date2);
        return (int) Math.abs(d1.getLong(ChronoField.EPOCH_DAY) - d2.getLong(ChronoField.EPOCH_DAY));
    }
}
