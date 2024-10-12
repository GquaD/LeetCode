package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2210 {
    //https://leetcode.com/problems/count-hills-and-valleys-in-an-array
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //2
    //ms
    //Beats
    //9.09%
    //Analyze Complexity
    //Memory
    //41.64
    //MB
    //Beats
    //30.51%
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int prev = 0;
        for (int n : nums) {
            if (n != prev) {
                list.add(n);
            }
            prev = n;
        }
        int res = 0;
        if (list.size() >= 3) {
            for (int i = 1; i < list.size() - 1; i++) {
                int a = list.get(i - 1), b = list.get(i), c = list.get(i + 1);
                if (a < b && b > c) res++;
                else if (a > b && b < c) res++;
            }
        }
        return res;
    }
}
