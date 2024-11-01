package LeetCode.easy;

public class Problem1957 {
    //https://leetcode.com/problems/delete-characters-to-make-fancy-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/delete-characters-to-make-fancy-string/solutions/5992912/java-one-pass-solution/
    //5min
    //Runtime
    //46
    //ms
    //Beats
    //34.88%
    //Analyze Complexity
    //Memory
    //45.53
    //MB
    //Beats
    //63.92%
    public String makeFancyString(String s) {
        if (s.length() < 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            int len = sb.length();
            char c = s.charAt(i);
            if (!(c == sb.charAt(len - 1) && c == sb.charAt(len - 2))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
