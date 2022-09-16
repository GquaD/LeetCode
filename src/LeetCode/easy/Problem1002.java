package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1002 {
    //https://leetcode.com/problems/find-common-characters/
    public static void main(String[] args) {
        LeetCodeUtils.printList(commonChars(new String[]{"bella", "label", "roller"}));
        LeetCodeUtils.printList(commonChars(new String[]{"cool", "lock", "cook"}));
    }

    //Runtime: 32 ms, faster than 16.75% of Java online submissions for Find Common Characters.
    //Memory Usage: 42.8 MB, less than 87.63% of Java online submissions for Find Common Characters.
    static List<String> commonChars(String[] words) {
        String word = words[0];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            boolean contains = true;
            for (int j = 0; j < words.length; j++) {
                if (!words[j].contains(word.charAt(i) + "")) {
                    contains = false;
                    break;
                } else {
                    words[j] = words[j].replaceFirst(word.charAt(i) + "", "");
                }
            }
            if (contains) {
                list.add(word.charAt(i) + "");
            }
        }
        return list;
    }

    static List<String> commonChars1(String[] words) {
        Set<String> list = new HashSet<>();
        String word = words[0];
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < word.length(); j++) {
                String l = word.charAt(i) + "";
                if (words[i].contains(l)) {
                    list.add(l);
                } else {
                    list.remove(l);
                }
            }
        }
        return new ArrayList<>(list);
    }

}
