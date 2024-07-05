package LeetCode.easy;

public class Problem3083 {
    //https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/solutions/5421518/java-100-faster/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.06
    //MB
    //Beats
    //77.74%
    static boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String r = sb.reverse().toString();
        sb.setLength(0);
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i)).append(s.charAt(i + 1));
            if (s.contains(sb.toString()) && r.contains(sb.toString())) return true;
            sb.setLength(0);
        }
        return false;
    }
}
