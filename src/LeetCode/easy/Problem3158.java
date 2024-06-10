package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3158 {
    //https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/description/


    //2min
    //Runtime
    //2
    //ms
    //Beats
    //72.62%
    //of users with Java
    //Memory
    //43.50
    //MB
    //Beats
    //16.87%
    //of users with Java
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (set.contains(n)) list.add(n);
            set.add(n);
        }
        if (list.isEmpty()) return 0;
        int xor = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            xor ^= list.get(i);
        }
        return xor;
    }
}
