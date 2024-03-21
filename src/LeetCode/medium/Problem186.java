package LeetCode.medium;

public class Problem186 {
    //https://leetcode.com/problems/reverse-words-in-a-string-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reverse-words-in-a-string-ii/solutions/4905892/java-o-n-solution/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //42.79%
    //of users with Java
    //Memory
    //48.61
    //MB
    //Beats
    //60.38%
    //of users with Java
    static void reverseWords(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
        int a = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                for (int j = a; j < (i + a) / 2; j++) {
                    char c = s[j];
                    s[j] = s[i - (j - a) - 1];
                    s[i - (j - a) - 1] = c;
                }
                a = i + 1;
            }
        }
        for (int j = a; j < (s.length + a) / 2; j++) {
            char c = s[j];
            s[j] = s[s.length - (j - a) - 1];
            s[s.length - (j - a) - 1] = c;
        }
    }
}
