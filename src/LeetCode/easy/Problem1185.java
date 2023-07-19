package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1185 {
    //https://leetcode.com/problems/day-of-the-week/
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(1, 1, 1971));
        System.out.println(dayOfTheWeek(31, 8, 2019));

    }

    //20 min
    //Runtime
    //Details
    //19ms
    //Beats 5.48%of users with Java
    //Memory
    //Details
    //45.00mb
    //Beats 5.76%of users with Java

    static String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] monthsLeap = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static Map<String, String> map;

    static String dayOfTheWeek(int day, int month, int year) {
        if (map == null) generateMap();
        int dayOfYear = calculateDayOfYear(day, month, year);
        return map.get(year + "_" + dayOfYear);
    }

    private static int calculateDayOfYear(int day, int month, int year) {
        int count = 0;
        if (isLeapYear(year)) for (int i = 0; i < month - 1; i++) count += monthsLeap[i];
        else for (int i = 0; i < month - 1; i++) count += months[i];
        return count + day;
    }

    private static void generateMap() {
        map = new HashMap<>();
        int year = 1971, startDayOfWeekIdx = 5;
        while (year < 2101) {
            for (int i = 1; i <= 365; i++) map.put(year + "_" + i, days[startDayOfWeekIdx++ % 7]);
            if (isLeapYear(year)) map.put(year + "_" + 366, days[startDayOfWeekIdx++ % 7]);
            year++;
        }
    }

    static boolean isLeapYear(long year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }
}
