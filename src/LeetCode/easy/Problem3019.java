package LeetCode.easy;

public class Problem3019 {
    //https://leetcode.com/problems/number-of-changing-keys/
    public static void main(String[] args) {

    }

    //5min
    //https://leetcode.com/problems/number-of-changing-keys/solutions/4639529/java-100-faster-o-n/
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.17
    //MB
    //Beats
    //100.00%
    //of users with Java
    static int countKeyChanges(String s) {
        int diff = Math.abs('A' - 'a'), count = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i), prev = s.charAt(i - 1);
            if (!(c - prev == 0 || Math.abs(c - prev) == diff)) count++;
        }
        return count;
    }
}
