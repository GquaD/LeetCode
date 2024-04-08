package LeetCode.easy;

public class Problem3099 {
    //https://leetcode.com/problems/harshad-number
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //39.99
    //MB
    //Beats
    //93.77%
    //of users with Java
    int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, t = x;
        while (t > 0) {
            sum += t % 10;
            t /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}
