package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem205 {

    //https://leetcode.com/problems/isomorphic-strings/

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("bar", "foo"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("egcd", "adfd"));
        System.out.println(isIsomorphic("abab", "baba")); //true
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
