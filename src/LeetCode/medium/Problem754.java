package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem754 {
    //https://leetcode.com/problems/reach-a-number/
    public static void main(String[] args) {
        System.out.println(reachNumber(1_000_000_000));
        System.out.println(reachNumber(9));
        System.out.println(reachNumber(2));
        System.out.println(reachNumber(3));
    }


    //20min
    //Runtime
    //8 ms
    //Beats
    //5.71%
    //Memory
    //41.3 MB
    //Beats
    //5.20%
    static List<Integer> list;

    static int reachNumber(int target) {

        if (list == null) {
            list = new ArrayList<>();
            int prev = 0;
            list.add(prev);
            do {
                prev++;
                list.add(prev + list.get(list.size() - 1));
            } while (list.get(list.size() - 1) <= 1_001_000_000);

            list.add(++prev + list.get(list.size() - 1));
        }

        int idx = Collections.binarySearch(list, Math.abs(target));
        if (idx >= 0) return idx;
        else idx = -idx -1;

        while ((list.get(idx) - target) % 2 == 1) idx++;
        return idx;
    }
}
