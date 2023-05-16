package LeetCode.medium;

public class Problem1753 {
    //https://leetcode.com/problems/maximum-score-from-removing-stones/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-score-from-removing-stones/solutions/3531349/java-o-1-1-line-100-faster-solution/
    //3 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.2 MB
    //Beats
    //94.72%
    static int maximumScore(int a, int b, int c) {
        int sum = a + b + c, max = Math.max(a, Math.max(b, c));
        return Math.min((a + b + c) / 2, sum - max);
    }
}
