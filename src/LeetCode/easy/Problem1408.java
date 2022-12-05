package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1408 {
    //https://leetcode.com/problems/string-matching-in-an-array/
    public static void main(String[] args) {
        LeetCodeUtils.printList(stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }

    //https://leetcode.com/problems/string-matching-in-an-array/solutions/2879487/java-93-faster-solution/
    //Runtime
    //4 ms
    //Beats
    //93.28%
    //Memory
    //42.4 MB
    //Beats
    //80.63%
    //5mins
    static List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(word)) {
                    set.add(word);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
