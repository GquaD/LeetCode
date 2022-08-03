package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2085 {
    //https://leetcode.com/problems/count-common-words-with-one-occurrence/
    public static void main(String[] args) {
        System.out.println(countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
        System.out.println(countWords(new String[]{"b","bb","bbb"}, new String[]{"a","aa","aaa"}));
        System.out.println(countWords(new String[]{"a","ab"}, new String[]{"a","a","a","ab"}));
    }
    //below 50
    //Runtime: 12 ms, faster than 26.84% of Java online submissions for Count Common Words With One Occurrence.
    //Memory Usage: 46.9 MB, less than 15.08% of Java online submissions for Count Common Words With One Occurrence.
    static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            if (map1.containsKey(words1[i])) {
                map1.put(words1[i], map1.get(words1[i]) + 1);
            } else {
                map1.put(words1[i], 1);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words2.length; i++) {
            if (map2.containsKey(words2[i])) {
                map2.put(words2[i], map2.get(words2[i]) + 1);
            } else {
                map2.put(words2[i], 1);
            }
        }

        int count;
        if (map1.size() >= map2.size()) {
            count = countOccurence(map1, map2);
        } else {
            count = countOccurence(map2, map1);
        }
        return count;
    }

    static int countOccurence(Map<String, Integer> map1, Map<String, Integer> map2){
        int count = 0;
        for (String key : map1.keySet()) {
            if (map1.get(key) != null && map2.get(key) != null) {
                if (map1.get(key) == 1 && map2.get(key) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
