package LeetCode.easy;

public class Problem3707 {
    //2min
    //https://leetcode.com/problems/equal-score-substrings/
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.27
    //MB
    //Beats
    //95.79%
    public static void main(String[] args) {

    }

    public boolean scoreBalance(String s) {
        int score = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            score += (s.charAt(i) - 'a') + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            temp += (s.charAt(i) - 'a') + 1;
            if (score - temp == temp) return true;
        }
        return false;
    }
}
