package LeetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2506 {
    //https://leetcode.com/problems/count-pairs-of-similar-strings/
    public static void main(String[] args) {
        System.out.println(similarPairs(new String[]{"aabb","ab","ba", "abb"}));
    }

    //https://leetcode.com/problems/count-pairs-of-similar-strings/solutions/2965945/java-94-time-93-memory-solution/
    //Runtime
    //6 ms
    //Beats
    //93.96%
    //Memory
    //42 MB
    //Beats
    //93.23%
    static int similarPairs(String[] words) {
        int len = words.length;
        if (len == 1) return 0;
        byte[][] alph = new byte[len][26];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (alph[i][idx] == 0) alph[i][idx]++;
            }
            String s = new String(alph[i]);
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int pairs = 0;
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (freq > 1) {
                pairs += (freq * (freq - 1)) / 2;
            }
        }
        return pairs;
    }
}
