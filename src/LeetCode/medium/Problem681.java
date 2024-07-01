package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem681 {
    //https://leetcode.com/problems/next-closest-time/
    public static void main(String[] args) {
        System.out.println(nextClosestTime("20:48"));
        System.out.println(nextClosestTime("23:59"));
        System.out.println(nextClosestTime("12:09"));
        System.out.println(nextClosestTime("01:32"));
    }

    //https://leetcode.com/problems/next-closest-time/solutions/5396479/java-brute-force-solution/
    //30min
    //Runtime
    //106
    //ms
    //Beats
    //5.12%
    //Analyze Complexity
    //Memory
    //41.20
    //MB
    //Beats
    //92.45%
    public static String nextClosestTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]), min = Integer.parseInt(split[1]);
        Set<Integer> set = new HashSet<>();
        int h = hour, m = min;
        if (h < 10 || m < 10) set.add(0);
        while (h > 0) {
            set.add(h % 10);
            h /= 10;
        }
        while (m > 0) {
            set.add(m % 10);
            m /= 10;
        }
        h = hour;
        m = min + 1;
        while (h < 24) {
            while (m < 60) {
                if (consistsOfTimeDigits(h, m, set)) {
                    return composeTime(h, m);
                }
                m++;
            }
            m = 0;
            h++;
        }

        h = 0;
        m = 0;
        while (h <= hour) {
            m = 0;
            while (m < 60) {
                if (consistsOfTimeDigits(h, m, set)) {
                    return composeTime(h, m);
                }
                m++;
            }
            h++;
        }
        return "00:00";
    }

    private static String composeTime(int h, int m) {
        StringBuilder sb = new StringBuilder();
        if (h < 10) sb.append(0);
        sb.append(h).append(":");
        if (m < 10) sb.append(0);
        sb.append(m);
        return sb.toString();
    }

    private static boolean consistsOfTimeDigits(int h, int m, Set<Integer> set) {
        if ((h < 10 || m < 10) && !set.contains(0)) {
            return false;
        }
        while (h > 0) {
            if (!set.contains(h % 10)) {
                return false;
            }
            h /= 10;
        }
        while (m > 0) {
            if (!set.contains(m % 10)) {
                return false;
            }
            m /= 10;
        }
        return true;
    }
}
