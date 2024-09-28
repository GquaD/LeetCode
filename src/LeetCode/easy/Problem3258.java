package LeetCode.easy;

public class Problem3258 {
    //https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i
    public static void main(String[] args) {

    }

    //15-20min
    //Runtime
    //3
    //ms
    //Beats
    //45.46%
    //Analyze Complexity
    //Memory
    //41.83
    //MB
    //Beats
    //94.04%
    int countKConstraintSubstrings(String s, int c) {
        int res = 0, one = 0, zero = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') zero++;
                else one++;
                if (one <= c || zero <= c) res++;
            }
            one = 0;
            zero = 0;
        }
        return res;
    }
}
