package LeetCode.medium;

public class Problem3084 {
    //https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/solutions/4888838/java-100-faster-3-lines-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //44.56
    //MB
    //Beats
    //100.00%
    //of users with Java
    static long countSubstrings(String s, char c) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == c) count++;
        return ((count + 1) * count) / 2;
    }
}
