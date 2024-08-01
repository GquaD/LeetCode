package LeetCode.medium;

public class Problem2380 {
    //https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string



    //https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/solutions/5568549/java-brute-force-solution/
    //5min
    //Runtime
    //216
    //ms
    //Beats
    //17.62%
    //Analyze Complexity
    //Memory
    //45.24
    //MB
    //Beats
    //9.25%
    public int secondsToRemoveOccurrences(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (s.contains("01")) {
            for (int i = 1; i < s.length(); i++) {
                char a = s.charAt(i - 1), b = s.charAt(i);
                if (a == '0' && b == '1') {
                    sb.append("10");
                    i++;
                } else {
                    sb.append(a);
                }
            }
            if (sb.length() < s.length()) {
                sb.append(s.charAt(s.length() - 1));
            }
            s = sb.toString();
            sb.setLength(0);
            count++;
        }
        return count;
    }
}
