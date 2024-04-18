package LeetCode.easy;

public class Problem3110 {
    //https://leetcode.com/problems/score-of-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/score-of-a-string/solutions/5040948/java-3lines-100-faster-solution/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //99.97%
    //of users with Java
    //Memory
    //42.02
    //MB
    //Beats
    //30.06%
    //of users with Java
    static int scoreOfString(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) sum += Math.abs(s.charAt(i - 1) - s.charAt(i));
        return sum;
    }
}
