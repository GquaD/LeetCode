package LeetCode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2848 {
    //https://leetcode.com/problems/points-that-intersect-with-cars/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //8
    //ms
    //Beats
    //8.46%
    //Memory
    //44.03
    //MB
    //Beats
    //78.58%
    int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> l : nums) {
            int s = l.get(0), e = l.get(1);
            for (int i = s; i <= e; i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}
