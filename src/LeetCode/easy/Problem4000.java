package LeetCode.easy;

public class Problem4000 {
    //5min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //42.66
    //MB
    //Beats
    //16.50%
    public int largestInteger(int n, int s) {
        if (s > 45) return -1;
        if (n == 4 && s > 36) return -1;
        if (n == 3 && s > 27) return -1;
        if (n == 2 && s > 18) return -1;
        if (n == 1 && s > 9) return -1;

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result *= 10;
            if (s >= 9) {
                result += 9;
                s -= 9;
            } else {
                result += s;
                s = 0;
            }
        }

        return result;
    }
}
