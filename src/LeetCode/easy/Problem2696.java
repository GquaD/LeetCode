package LeetCode.easy;

public class Problem2696 {
    //https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
    public static void main(String[] args) {

    }

    //5 min
    //Runtime
    //32 ms
    //Beats
    //10.16%
    //Memory
    //44.7 MB
    //Beats
    //7.48%
    static int minLength(String s) {
        String a = "AB", c = "CD";

        StringBuilder sb = new StringBuilder();
        while (s.contains(a)) {
            String[] splitA = s.split(a);
            for (String st : splitA) sb.append(st);
            s = sb.toString();
            sb.setLength(0);
        }
        while (s.contains(c)) {
            String[] splitA = s.split(c);
            for (String st : splitA) sb.append(st);
            s = sb.toString();
            sb.setLength(0);
        }

        return s.length();
    }
}
