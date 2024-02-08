package LeetCode.medium;

public class Problem2330 {
    //https://leetcode.com/problems/valid-palindrome-iv/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-palindrome-iv/solutions/4697316/java-o-n-solution/
    //5min
    //Runtime
    //3
    //ms
    //Beats
    //68.93%
    //of users with Java
    //Memory
    //44.32
    //MB
    //Beats
    //48.79%
    //of users with Java
    static boolean makePalindrome(String s) {
        int n = s.length(), count = 0;
        if (n <= 5) return true;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) count++;
            if (count > 2) return false;
        }
        return true;
    }
}
