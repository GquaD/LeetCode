package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem441 {
    //https://leetcode.com/problems/arranging-coins/
    public static void main(String[] args) {
        System.out.println(arrangeCoins(2));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(10));
    }

    //https://leetcode.com/problems/arranging-coins/solutions/3760716/java-arraylist-as-a-cache-straightforward-solution/
    //15-20 min
    //Runtime
    //7 ms
    //Beats
    //45.38%
    //Memory
    //44.7 MB
    //Beats
    //5.65%
    static List<Integer> list;
    static int arrangeCoins(int n) {
        if (list == null) {
            list = new ArrayList<>();
            list.add(0);
            int sum = 0;
            for (int i = 1; i < 70000; i++) {
                sum += i;
                if (sum < 0) break;
                list.add(sum);
            }
        }
        int idx = Collections.binarySearch(list, n);
        return idx < 0 ? -idx - 2 : idx;
    }
}
