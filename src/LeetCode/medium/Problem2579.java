package LeetCode.medium;

public class Problem2579 {
    //https://leetcode.com/problems/count-total-number-of-colored-cells/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/count-total-number-of-colored-cells/solutions/3306200/java-1-line-math-100-faster-explained/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.6 MB
    //Beats
    //52.32%
    static long coloredCells(int n) {
        return ((1L + n * 2 - 1) * n) - (n * 2 - 1);
    }

    //5-10 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.8 MB
    //Beats
    //34.72%
    static long coloredCells1(int n) {
        long a = 1, an = n * 2 - 1, sum = ((a + an) * n) / 2;
        return sum + sum - an;
    }
}
