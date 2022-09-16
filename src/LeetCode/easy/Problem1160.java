package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1160 {
    //https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    //Runtime: 53 ms, faster than 34.71% of Java online submissions for Find Words That Can Be Formed by Characters.
    //Memory Usage: 61.5 MB, less than 23.55% of Java online submissions for Find Words That Can Be Formed by Characters.
    static int countCharacters(String[] words, String chars) {
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
