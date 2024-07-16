package LeetCode.easy;

public class Problem3216 {
    //https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/solutions/5485395/java-100-faster-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.98
    //MB
    //Beats
    //43.08%
    public String getSmallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int prev = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (prev % 2 == cur % 2 && cur < prev) {
                sb.append(s.substring(0, i - 1));
                sb.append(cur);
                sb.append(prev);
                sb.append(s.substring(i + 1));
                break;
            }
            prev = cur;
        }
        return sb.length() == 0 ? s : sb.toString();
    }
}
