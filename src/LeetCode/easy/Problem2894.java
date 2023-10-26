package LeetCode.easy;

public class Problem2894 {
    //https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
    public static void main(String[] args) {

    }

    //1 min
    //Runtime
    //1 ms
    //Beats
    //93.72%
    //Memory
    //39.7 MB
    //Beats
    //41.16%
    static int differenceOfSums(int n, int m) {
        int n1 = 0, n2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) n2 += i;
            else n1 += i;
        }
        return n1 - n2;
    }
}
