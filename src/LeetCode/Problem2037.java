package LeetCode;

import java.util.Arrays;

public class Problem2037 {
    //https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));
        System.out.println(minMovesToSeat(new int[]{2,2,6,6}, new int[]{1,3,2,6}));
    }

    //Runtime: 4 ms, faster than 73.17% of Java online submissions for Minimum Number of Moves to Seat Everyone.
    //Memory Usage: 45.2 MB, less than 7.12% of Java online submissions for Minimum Number of Moves to Seat Everyone.
    static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
