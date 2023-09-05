package LeetCode.medium;

public class Problem2109 {
    //https://leetcode.com/problems/adding-spaces-to-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/adding-spaces-to-a-string/solutions/4005514/java-o-n-stringbuilder/
    //5min
    //Runtime
    //21 ms
    //Beats
    //86.1%
    //Memory
    //77.9 MB
    //Beats
    //82.25%
    static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
