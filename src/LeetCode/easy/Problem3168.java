package LeetCode.easy;

public class Problem3168 {
    //https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room


    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.38
    //MB
    //Beats
    //9.12%
    //of users with Java
    public int minimumChairs(String s) {
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
