package LeetCode.easy;

public class Problem1180 {
    //https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //40.88
    //MB
    //Beats
    //93.88%
    //of users with Java
    static int countLetters(String s) {
        int count = 1, sum = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == prev) {
                count++;
            } else {
                sum += (count * (count + 1)) / 2;
                count = 1;
                prev = cur;
            }
        }
        sum += (count * (count + 1)) / 2;
        return sum;
    }
}
