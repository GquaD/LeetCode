package LeetCode.easy;

public class Problem3992 {
    //2min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //45.22
    //MB
    //Beats
    //-%
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == y) sb.append(y);
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != y) sb.append(s.charAt(i));
        return sb.toString();
    }
}
