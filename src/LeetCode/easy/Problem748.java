package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem748 {
    //10min

    //Runtime
    //4
    //ms
    //Beats
    //74.52%
    //Memory
    //46.43
    //MB
    //Beats
    //52.63%
    public String shortestCompletingWord(String s, String[] words) {
        s = s.toLowerCase();
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                alph[c - 'a']++;
        }
        List<String> list = new ArrayList<>();
        for (String word: words) {
            int[] w = new int[26];
            for (int i = 0; i < word.length(); i++) w[word.charAt(i) - 'a']++;
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (alph[i] > w[i]) {
                    found = false;
                }
            }
            if (found) list.add(word);
        }

        int len = 15;
        String result = "";
        for (String word: list) {
            if (word.length() < len) {
                len = word.length();
                result = word;
            }
        }

        return result;
    }
}
