package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem459 {
    //https://leetcode.com/problems/repeated-substring-pattern/
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    //nn
    //35 min
    //Runtime
    //75 ms
    //Beats
    //50.12%
    //Memory
    //43.7 MB
    //Beats
    //94.79%
    static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    static boolean repeatedSubstringPattern6(String s) {
        String ss = s + s, half = ss.substring(1, ss.length() - 1);
        return half.contains(s);
    }

    static boolean repeatedSubstringPattern5(String s) {
        if (s.length() % 2 != 0) return false;
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) if (s.charAt(i) != s.charAt(half + i)) return false;
        return true;
    }
    static boolean repeatedSubstringPattern3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int min = 10_001;
        for (char c : map.keySet()) min = Math.min(min, map.get(c));
        if (min == 1) return false;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (char c : map.keySet()) map1.put(c, map.get(c) / min);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
            if (map1.get(s.charAt(i)) < map2.get(s.charAt(i))) break;
            sb.append(s.charAt(i));
        }
        String pattern = sb.toString();
        if (s.length() % pattern.length() != 0) return false;
        for (int i = 0; i < s.length(); i += pattern.length()) {
            for (int j = i; j < i + pattern.length(); j++) {
                if (s.charAt(j) != pattern.charAt(j - i)) return false;
            }
        }
        return true;
    }

    static boolean repeatedSubstringPattern2(String s) {
        int prev = 0, alph[] = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) {
                if (prev == 0) {
                    prev = alph[i];
                    continue;
                }
                if (alph[i] != prev) return false;
            }
        }
        return prev != 1;
    }

    static boolean repeatedSubstringPattern1(String s) {
        int len = s.length();
        int n = 2, limit = (int) Math.sqrt(len) + 1;
        while (n <= limit) {
            if (len % n == 0) {

            }
        }
        return false;
    }
}
