package LeetCode.easy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Problem387 {
    //https://leetcode.com/problems/first-unique-character-in-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/first-unique-character-in-a-string/solutions/2868827/java-using-hashmap-28ms-explained/
    //Runtime
    //28 ms
    //Beats
    //63.11%
    //Memory
    //48.3 MB
    //Beats
    //69.84%
    static int firstUniqChar(String s) {
        int[] alph = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alph[c - 'a']++;
            if (map.keySet().size() < 26) {
                if (!map.containsKey(c)) {
                    map.put(c, i);
                }
            }
        }
        int minIdx = s.length();
        for (char c : map.keySet()) {
            if (alph[c - 'a'] == 1) {
                int idx = map.get(c);
                if (minIdx > idx) minIdx = idx;
            }
        }
        return minIdx == s.length() ? -1 : minIdx;
    }
}
