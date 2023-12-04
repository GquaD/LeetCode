package LeetCode.medium;

import java.util.Arrays;
import java.util.List;

public class Problem524 {
    //https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(findLongestWord("abce", Arrays.asList("abe","abc")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    //https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/solutions/4361549/java-o-n-m-solution/
    //15 min
    //Runtime
    //19 ms
    //Beats
    //54.19%
    //Memory
    //44.5 MB
    //Beats
    //37.62%
    static String findLongestWord(String s, List<String> dictionary) {
        int max = 0, idx = 0;
        String res = "";
        for (String t : dictionary) {
            for (int i = 0; i < s.length(); i++) if (idx < t.length() && s.charAt(i) == t.charAt(idx)) idx++;
            if (idx == t.length() && idx > max) {
                res = t;
                max = idx;
            } else if (idx == t.length() && idx == max) {
                if (res.length() == 0) res = t;
                else res = res.compareTo(t) > 0 ? t : res;
            }
            idx = 0;
        }
        return res;
    }
}
