package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem3803 {
    //https://leetcode.com/problems/count-residue-prefixes/

    //2min
    //Runtime
    //2
    //ms
    //Beats
    //66.86%
    //Analyze Complexity
    //Memory
    //44.38
    //MB
    //Beats
    //26.73%
    public int residuePrefixes(String s) {
        int residue = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() == (i + 1) % 3)
                residue++;
        }
        return residue;
    }
}
