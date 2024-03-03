package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem3032 {
    //https://leetcode.com/problems/count-numbers-with-unique-digits-ii/
    public static void main(String[] args) {
        System.out.println(numberCount(1,20));
    }

    //https://leetcode.com/problems/count-numbers-with-unique-digits-ii/solutions/4817841/java-straightforward-division-solution/
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //69.84%
    //of users with Java
    //Memory
    //44.46
    //MB
    //Beats
    //37.14%
    //of users with Java
    static int numberCount(int a, int b) {
        int count = 0;
        int arr[] = new int[10];
        for (int i = a; i <= b; i++) {
            int t = i;
            while (t > 0) {
                int rem = t % 10;
                if (arr[rem]++ > 0) {
                    count++;
                    break;
                }
                t /= 10;
            }
            arr = new int[10];
        }
        return b - a - count + 1;
    }

    static Set<Integer> set;
    static int numberCount1(int a, int b) {
        if (set == null) {
            set = new HashSet<>();
            Set<Integer> temp = new HashSet<>();
            for (int i = 1; i <= 1000; i++) {
                int t = i;
                while (t > 0) {

                }
            }
        }
        return 1;
    }
}
