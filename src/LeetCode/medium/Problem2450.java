package LeetCode.medium;

public class Problem2450 {
    //https://leetcode.com/problems/number-of-distinct-binary-strings-after-applying-operations/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-distinct-binary-strings-after-applying-operations/solutions/5998067/java-o-n-solution/
    //2min
    //Runtime
    //3
    //ms
    //Beats
    //66.67%
    //Analyze Complexity
    //Memory
    //44.70
    //MB
    //Beats
    //33.33%
    public int countDistinctStrings(String s, int k) {
        long res = 1;
        for (int i = 0; i < s.length() - k + 1; i++) {
            res *= 2;
            res %= 1_000_000_007;
        }
        return (int) res;
    }
}
