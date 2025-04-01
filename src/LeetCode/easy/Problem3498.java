package LeetCode.easy;

public class Problem3498 {
    //https://leetcode.com/problems/reverse-degree-of-a-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reverse-degree-of-a-string/solutions/6604860/java-100-faster-solution-by-tbekpro-p8vb/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.67
    //MB
    //Beats
    //92.21%
    public int reverseDegree(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int score = (26 - (s.charAt(i) - 'a')) * (i + 1);
            result += score;
        }
        return result;
    }
}
