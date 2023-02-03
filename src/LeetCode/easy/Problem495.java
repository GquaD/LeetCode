package LeetCode.easy;

public class Problem495 {
    //https://leetcode.com/problems/teemo-attacking/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/teemo-attacking/solutions/3134874/java-3-lines-o-n-solution/
    //5 min
    //Runtime
    //2 ms
    //Beats
    //90.24%
    //Memory
    //44.4 MB
    //Beats
    //85.83%
    static int findPoisonedDuration(int[] t, int d) {
        int sum = d;
        for (int i = 1; i < t.length; i++) sum += t[i - 1] + d - 1 < t[i] ? d : t[i] - t[i - 1];
        return sum;
    }
}
