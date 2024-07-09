package LeetCode.easy;

public class Problem3210 {
    //https://leetcode.com/problems/find-the-encrypted-string
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.64
    //MB
    //Beats
    //55.62%
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (i + k) % s.length();
            sb.append(s.charAt(idx));
        }
        return sb.toString();
    }
}
