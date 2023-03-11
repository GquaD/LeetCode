package LeetCode.medium;

import java.util.Random;

public class Problem470 {
    //https://leetcode.com/problems/implement-rand10-using-rand7
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println();
    }

    public static int rand7() {
        return random.nextInt(7) + 1;
    }

    //nnnn
    //Runtime
    //7 ms
    //Beats
    //53.31%
    //Memory
    //48.6 MB
    //Beats
    //12.40%
    public static int rand10() {
        int n40 = 40;
        while (n40 >= 40) {
            n40 = (rand7() - 1) * 7 + rand7() - 1;
        }
        return n40 % 10 + 1;
    }
}
