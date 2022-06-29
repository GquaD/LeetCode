package LeetCode;

public class Problem1342 {
    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public static void main(String[] args) {

    }
    // faster than 100 percent, took 0 ms
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            steps++;
        }
        return steps;
    }
}
