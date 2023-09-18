package LeetCode.medium;

import java.util.Arrays;

public class Problem2126 {
    //https://leetcode.com/problems/destroying-asteroids/
    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed(10, new int[]{3,9,19,5,21}));
        System.out.println(asteroidsDestroyed(5, new int[]{4,9,23,4}));
    }

    //https://leetcode.com/problems/destroying-asteroids/solutions/4060347/java-simple-o-n-solution/
    //15 min
    //Runtime
    //22 ms
    //Beats
    //87.19%
    //Memory
    //57.5 MB
    //Beats
    //33.70%
    static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int a : asteroids) {
            if (m >= a) m += a;
            else return false;
        }
        return true;
    }
}
