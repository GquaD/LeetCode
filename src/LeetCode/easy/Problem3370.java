package LeetCode.easy;

public class Problem3370 {
    //https://leetcode.com/problems/smallest-number-with-all-set-bits
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-number-with-all-set-bits/solutions/6112382/java-o-logn-solution/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.75
    //MB
    //Beats
    //77.11%
    public int smallestNumber(int n) {
        int a = 1;
        while (a <= n) a *= 2;
        return a - 1;
    }
}
