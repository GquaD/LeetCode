package LeetCode.easy;

public class Problem3959 {
    //2min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //42.39
    //MB
    //Beats
    //-%
    public boolean checkGoodInteger(int n) {
        int sum = 0, square = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t;
            square += t * t;
            n /= 10;
        }

        return square - sum >= 50;
    }
}
