package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem290 {
    //https://leetcode.com/problems/word-pattern/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/word-pattern/solutions/2855801/java-1ms-98-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //98.18%
    //Memory
    //40.3 MB
    //Beats
    //87.69%
    static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) return false;
            } else {
                if (map.values().contains(words[i])) return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }


    static boolean wordPattern1(String pattern, String s) {
        String[] pairs = new String[26];
        String[] words = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (pairs[c - 'a'] == null) {
                pairs[c - 'a'] = words[i];
            } else if (!pairs[c - 'a'].equals(words[i])) return false;
        }
        return true;
    }
}
