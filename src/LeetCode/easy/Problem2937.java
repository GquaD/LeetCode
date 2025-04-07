package LeetCode.easy;

public class Problem2937 {
    //https://leetcode.com/problems/make-three-strings-equal
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/make-three-strings-equal/solutions/6625340/java-100-faster-solution-by-tbekpro-vyqn/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.83
    //MB
    //Beats
    //47.14%
    public int findMinimumOperations(String s1, String s2, String s3) {
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int len = 0;
        for (int i = 0; i < min; i++) {
            char c  = s1.charAt(i);
            if (s2.charAt(i) == c && s3.charAt(i) == c) {
                len++;
            } else if (len == 0) {
                return -1;
            } else {
                break;
            }
        }
        return s1.length() - len + s2.length() - len + s3.length() - len;
    }
}
