package LeetCode.medium;

public class Problem1780 {
    //https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.4 MB
    //Beats
    //44.52%
    static boolean checkPowersOfThree(int n) {
        while (n > 0 && n % 3 != 2)
            n = n % 3 == 1 ? n - 1 : n / 3;
        return n == 0;
    }
}
