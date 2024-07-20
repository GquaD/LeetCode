package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem3039 {
    //https://leetcode.com/problems/apply-operations-to-make-string-empty

    //https://leetcode.com/problems/apply-operations-to-make-string-empty/solutions/5505988/java-freq-counting-solution/
    //15min
    //Runtime
    //55
    //ms
    //Beats
    //45.49%
    //Analyze Complexity
    //Memory
    //51.93
    //MB
    //Beats
    //60.07%
    public String lastNonEmptyString(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = alph[i];
            if (freq > max) {
                set.clear();
                max = freq;
                set.add((char) ('a' + i));
            } else if (freq == max) {
                set.add((char) ('a' + i));
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (set.contains(c) && !visited.contains(c)) {
                sb.append(c);
                visited.add(c);
            }
        }
        return sb.reverse().toString();
    }
}
