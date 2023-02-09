package LeetCode.easy;

public class Problem796 {
    //https://leetcode.com/problems/rotate-string/
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

    //https://leetcode.com/problems/rotate-string/solutions/3163117/java-1-ms-solution/
    //5 min
    //Runtime
    //1 ms
    //Beats
    //45.41%
    //Memory
    //40.9 MB
    //Beats
    //34.31%
    static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.substring(1)).append(s.charAt(0));
            s = sb.toString();
            if (s.equals(goal)) return true;
            sb.setLength(0);
        }
        return false;
    }
}
