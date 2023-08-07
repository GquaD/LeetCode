package LeetCode.easy;

public class Problem2810 {
    //https://leetcode.com/problems/faulty-keyboard/
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //3 ms
    //Beats
    //100%
    //Memory
    //43.5 MB
    //Beats
    //100%
    static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                sb.reverse();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
