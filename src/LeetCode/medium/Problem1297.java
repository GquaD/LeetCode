package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1297 {
    //https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 1, 3, 3));
    }

    //https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/solutions/3873010/java-hashmap-alphabet-array/
    //10-15min
    //Runtime
    //466 ms
    //Beats
    //11.44%
    //Memory
    //56.6 MB
    //Beats
    //15.80%
    static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int i = minSize; i <= maxSize; i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, j + i);
                if (hasMaxLetters(sub, maxLetters)) map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
            for (String sub : map.keySet()) {
                maxFreq = Math.max(map.get(sub), maxFreq);
            }
            map = new HashMap<>();
        }
        return maxFreq;
    }
    static int[] alph;
    private static boolean hasMaxLetters(String sub, int maxLetters) {
        if (alph == null) alph = new int[26];
        for (int i = 0; i < sub.length(); i++) alph[sub.charAt(i) - 'a']++;
        int count = 0;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] > 0) count++;
            alph[i] = 0;
        }
        return count <= maxLetters;
    }


}
