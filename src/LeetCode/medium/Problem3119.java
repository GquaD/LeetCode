package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3119 {
    //https://leetcode.com/problems/maximum-number-of-potholes-that-can-be-fixed/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-number-of-potholes-that-can-be-fixed/solutions/5045354/java-greedy-100-faster/
    //10-15min
    //Runtime
    //84
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.51
    //MB
    //Beats
    //100.00%
    //of users with Java
    static int maxPotholes(String road, int budget) {
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < road.length(); i++) {
            boolean isHole = road.charAt(i) == 'x';
            if (isHole) {
                cur++;
            } else {
                if (cur > 0) list.add(cur);
                cur = 0;
            }
        }
        if (cur > 0) list.add(cur);
        Collections.sort(list, (a, b) -> b - a);
        int res = 0;
        for (int n : list) {
            if (budget <= 1) break;
            if (n + 1 <= budget) {
                budget -= n + 1;
                res += n;
            } else {
                res += budget - 1;
                budget = 0;
            }
        }
        return res;
    }
}
