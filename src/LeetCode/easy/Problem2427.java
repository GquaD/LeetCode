package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2427 {
    //https://leetcode.com/problems/number-of-common-factors/
    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));
        System.out.println(commonFactors(6, 12));
        System.out.println(commonFactors(25, 30));
        System.out.println(commonFactors(24, 48));
        System.out.println(commonFactors(2, 2));
        System.out.println(commonFactors(885, 885));
        System.out.println(commonFactors(3, 3));
        System.out.println(commonFactors(840, 840));
    }

    //https://leetcode.com/problems/number-of-common-factors/solutions/2689235/java-straightforward-approach/
    //Runtime
    //1 ms
    //Beats
    //80.65%
    //Memory
    //41.6 MB
    //Beats
    //9.11%

    static int commonFactors(int a, int b) {
        int count = 1;
        int greater = a >= b ? a : b;
        int smaller = a < b ? a : b;
        int div = 2;
        while (div <= smaller) {
            if (greater % div == 0 && smaller % div == 0) {
                count++;
            }
            div++;
        }
        return count;
    }

    static int commonFactors1(int a, int b) {
        Set<Integer> visited = new HashSet<>();
        int count = 1;
        if (a == b && (a != 1 && a != 2)) count++;
        int greater = a >= b ? a : b;
        int smaller = a < b ? a : b;
        int sqrt =  (int) Math.sqrt(smaller) + 1;
        int div = 2, temp = div;
        while (div <= sqrt) {
            if (temp > smaller) {
                div++;
                temp = div;
                continue;
            }
            if (greater % temp == 0 && smaller % temp == 0 && !visited.contains(temp)) {
                count++;
            }
            visited.add(temp);
            temp += div;
        }
        return count;
    }
}
