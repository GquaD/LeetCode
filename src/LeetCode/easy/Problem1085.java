package LeetCode.easy;

public class Problem1085 {
    //https://leetcode.com/problems/sum-of-digits-in-the-minimum-number
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.16
    //MB
    //Beats
    //61.90%
    //of users with Java
    static int sumOfDigits(int[] nums) {
        int min = 101;
        for (int n : nums) min = Math.min(min, n);
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        return sum % 2 == 1 ? 0 : 1;
    }
}
