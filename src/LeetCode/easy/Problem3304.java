package LeetCode.easy;

public class Problem3304 {
    //https://leetcode.com/problems/find-the-k-th-character-in-string-game-i
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/solutions/5860015/java-straightforward-solution/
    //5min
    //Runtime
    //4
    //ms
    //Beats
    //60.39%
    //Analyze Complexity
    //Memory
    //42.65
    //MB
    //Beats
    //55.54%
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");

        while (sb.length() < k) {
            String s = sb.toString();
            sb.setLength(0);
            for (int i = 0; i < s.length(); i++) {
                char c = (char) ((((s.charAt(i) - 'a') + 1) % 26) + 'a');
                sb.append(c);
            }
            String s1 = sb.toString();
            sb.setLength(0);
            sb.append(s);
            sb.append(s1);
        }
        return sb.charAt(k - 1);
    }
}
