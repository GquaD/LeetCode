package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1858 {
    //https://leetcode.com/problems/longest-word-with-all-prefixes/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-word-with-all-prefixes/solutions/5100889/java-straightforward-solution/
    //15min
    //Runtime
    //224
    //ms
    //Beats
    //9.09%
    //of users with Java
    //Memory
    //46.79
    //MB
    //Beats
    //80.30%
    //of users with Java
    static String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String res = "";
        for (String w : words) set.add(w);
        for (String w: set) {
            boolean all = true;
            for (int i = 1; i < w.length(); i++) {
                String sub = w.substring(0, i);
                if (!set.contains(sub)) {
                    all = false;
                    break;
                }
            }
            if (all) {
                if (res.length() == 0)
                    res = w;
                else if (w.length() > res.length())
                    res = w;
                else if (w.compareTo(res) < 0 && w.length() == res.length())
                    res = w;
            }
        }
        return res;
    }
}
