package LeetCode.easy;

public class Problem3330 {
    //https://leetcode.com/problems/find-the-original-typed-string-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-original-typed-string-i/solutions/5974461/java-one-pass-solution/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.74
    //MB
    //Beats
    //100.00%
    public int possibleStringCount(String word) {
        int res = 1;
        for (int i = 0; i < word.length() - 1; i++) if (word.charAt(i) == word.charAt(i + 1)) res++;
        return res;
    }
}
