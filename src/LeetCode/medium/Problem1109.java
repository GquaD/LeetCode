package LeetCode.medium;

import java.util.Arrays;

public class Problem1109 {
    //https://leetcode.com/problems/corporate-flight-bookings/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings1(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }

    //https://leetcode.com/problems/corporate-flight-bookings/solutions/3811054/java-o-nlogn-sorting/
    //20-30 min
    //Runtime
    //34 ms
    //Beats
    //35.32%
    //Memory
    //55 MB
    //Beats
    //95.84%
    static int[] corpFlightBookings1(int[][] bookings, int n) {
        Arrays.sort(bookings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] res = new int[n];
        for (int[] arr : bookings) {
            res[arr[0] - 1] += arr[2];
            if (arr[1] < res.length) res[arr[1]] -= arr[2];
        }
        for (int i = 1; i < res.length; i++) res[i] += res[i - 1];

        return res;
    }
}
