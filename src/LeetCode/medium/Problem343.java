package LeetCode.medium;

public class Problem343 {
    //https://leetcode.com/problems/integer-break/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/integer-break/solutions/3411096/java-100-faster-solution/
    //30 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.7 MB
    //Beats
    //32.13%
    static int integerBreak(int n) {
        if (n < 5) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 4;
        }
        int num3 = n / 3, rem = n % 3;
        if (rem == 1) {
            rem = 4;
            num3--;
        }
        int res = 1;
        for (int i = 0; i < num3; i++) res *= 3;
        if (rem != 0) res *= rem;
        return res;
    }
}
