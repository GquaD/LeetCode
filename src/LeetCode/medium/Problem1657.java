package LeetCode.medium;

import java.util.*;

public class Problem1657 {
    //https://leetcode.com/problems/determine-if-two-strings-are-close/
    public static void main(String[] args) {
        System.out.println(closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
    }

    //https://leetcode.com/problems/determine-if-two-strings-are-close/solutions/4287336/java-o-n-frequency-map/
    //20min
    //Runtime
    //48 ms
    //Beats
    //57.27%
    //Memory
    //44.2 MB
    //Beats
    //91.5%
    static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] alph1 = new int[26], alph2 = new int[26];
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            alph1[word1.charAt(i) - 'a']++;
            alph2[word2.charAt(i) - 'a']++;
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
        }
        if (set1.size() != set2.size()) return false;
        for (char c : set1) if (!set2.contains(c)) return false;
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (alph1[i] > 0) map1.put(alph1[i], map1.getOrDefault(alph1[i], 0) + 1);
            if (alph2[i] > 0) map2.put(alph2[i], map2.getOrDefault(alph2[i], 0) + 1);
        }
        if (map1.size() != map2.size()) return false;
        for (int k : map1.keySet()) {
            if (!map2.containsKey(k)) return false;
            if (!Objects.equals(map1.get(k), map2.get(k))) return false;
        }
        return true;
    }
}
