package LeetCode.easy;

public class Problem1134 {
    //https://leetcode.com/problems/armstrong-number/description/

    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //40.42
    //MB
    //Beats
    //35.54%
    //of users with Java
    boolean isArmstrong(int n) {
        int sum = 0, k = 0, t = n;
        while (t > 0) {
            k++;
            t /= 10;
        }
        t = n;
        while (t > 0) {
            sum += Math.pow(t % 10, k);
            t /= 10;
        }
        return n == sum;
    }
}
