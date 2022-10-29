package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2068 {
    //https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/solutions/2755130/java-in-just-3-ms-2-solutions/
    //Runtime
    //3 ms
    //Beats
    //38.17%
    //Memory
    //41.9 MB
    //Beats
    //79.43%
    static boolean checkAlmostEquivalent(String word1, String word2) {
        byte[] alph = new byte[26];
        for (char c : word1.toCharArray()) {
            alph[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            alph[c - 'a']--;
        }

        for (byte n : alph) {
            if (Math.abs(n) > 3) return false;
        }
        return true;
    }


    //10 mins
    //Runtime
    //7 ms
    //Beats
    //15.81%
    //Memory
    //42.5 MB
    //Beats
    //41%
    static boolean checkAlmostEquivalent1(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : word2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, -1);
            }
        }

        for (char key : map.keySet()) {
            if (Math.abs(map.get(key)) > 3) return false;
        }
        return true;
    }
}
