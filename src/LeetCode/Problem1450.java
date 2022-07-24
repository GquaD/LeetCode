package LeetCode;

public class Problem1450 {
    //https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4));
        System.out.println(busyStudent(new int[]{4}, new int[]{4}, 4));
    }

    //Runtime: 1 ms, faster than 32.51% of Java online submissions for Number of Students Doing Homework at a Given Time.
    //Memory Usage: 42.1 MB, less than 49.31% of Java online submissions for Number of Students Doing Homework at a Given Time.
    static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
