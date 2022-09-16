package LeetCode.easy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Problem2325 {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    //https://leetcode.com/problems/decode-the-message/
    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        decodeMessage("", "");
    }

    //Runtime: 19 ms, faster than 21.78% of Java online submissions for Decode the Message.
    //Memory Usage: 44 MB, less than 35.80% of Java online submissions for Decode the Message.
    static String decodeMessage(String key, String message) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ') {
                set.add(key.charAt(i));
            }
        }
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for (Character c : set) {
            map.put(c, alphabet.charAt(count++));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                sb.append(map.get(message.charAt(i)));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


}
