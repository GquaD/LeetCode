package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1160 {
    //https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    //5min
    //Runtime
    //8 ms
    //Beats
    //65.56%
    //Memory
    //44.1 MB
    //Beats
    //56.30%
    static int countCharacters(String[] words, String chars) {
        int count = 0, alph[] = new int[26];
        for (int i = 0; i < chars.length(); i++) alph[chars.charAt(i) - 'a']++;
        for (String word : words) {
            int[] alph1 = new int[26];
            for (int i = 0; i < word.length(); i++) alph1[word.charAt(i) - 'a']++;
            boolean isGood = true;
            for (int i = 0; i < 26; i++) {
                if (alph1[i] > alph[i]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) count += word.length();
        }
        return count;
    }

    //Runtime: 53 ms, faster than 34.71% of Java online submissions for Find Words That Can Be Formed by Characters.
    //Memory Usage: 61.5 MB, less than 23.55% of Java online submissions for Find Words That Can Be Formed by Characters.
    static int countCharacters1(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char key = chars.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> mapTemp = new HashMap<>(map);
            boolean isGood = true;
            for (int j = 0; j < words[i].length(); j++) {
                char temp = words[i].charAt(j);
                if (mapTemp.containsKey(temp) && mapTemp.get(temp) > 0) {
                    mapTemp.put(temp, mapTemp.get(temp) - 1);
                } else {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                count += words[i].length();
            }
        }
        return count;
    }
}
