package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem890 {
    //https://leetcode.com/problems/find-and-replace-pattern/
    public static void main(String[] args) {
        LeetCodeUtils.printList(findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
        LeetCodeUtils.printList(findAndReplacePattern(new String[]{"a","b","c"}, "a"));
    }

    //todo
    //15 mins
    //Runtime: 4 ms, faster than 26.36% of Java online submissions for Find and Replace Pattern.
    //Memory Usage: 42.7 MB, less than 80.71% of Java online submissions for Find and Replace Pattern.
    static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Map<Character, Character> map = new HashMap<>();
            boolean addToList = true;
            for (int j = 0; j < words[i].length(); j++) {
                char key = pattern.charAt(j);
                char val = words[i].charAt(j);
                if (map.containsKey(key)) {
                    char expected = map.get(key);
                    if(val != expected) {
                        addToList = false;
                        break;
                    }
                } else {
                    if (!map.values().contains(val)) {
                        map.put(key, val);
                    } else {
                        addToList = false;
                        break;
                    }
                }
            }
            if (addToList) {
                list.add(words[i]);
            }
        }
        return list;
    }
}
