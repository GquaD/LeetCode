package LeetCode.easy;

public class Problem3954 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //42.73
    //MB
    //Beats
    //43.61%
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        for (int i = Math.max(n - k, 1); i <= n + k; i++) if ((n & i) == 0) sum += i;
        return sum;
    }
}
