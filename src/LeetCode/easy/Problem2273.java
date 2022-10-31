package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem2273 {
    //https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
    public static void main(String[] args) {
        LeetCodeUtils.printList(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
    }

    //https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/solutions/2762311/java-88-faster-not-using-maps/
    //Runtime
    //4 ms
    //Beats
    //88.17%
    //Memory
    //44.1 MB
    //Beats
    //85.43%
    static List<String> removeAnagrams(String[] words) {
        alph = new short[26];
        if (words.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(words[0]);
            return list;
        }

        List<String> list = new ArrayList<>(words.length);

        for (String word : words) {
            list.add(word);
        }
        int idx = 1;
        while (idx < list.size()) {
            if (hasNextAnagram(list, idx)) {
                list.remove(idx);
                continue;
            }
            idx++;
        }
        return list;
    }

    private static boolean hasNextAnagram(List<String> list, int idx) {
        return isAnagram(list.get(idx), list.get(idx - 1));
    }
    static short[] alph;
    private static boolean isAnagram(String one, String two) {
        for (int i = 0; i < one.length(); i++) {
            char c = one.charAt(i);
            alph[c - 'a']++;
        }
        for (int i = 0; i < two.length(); i++) {
            char c = two.charAt(i);
            alph[c - 'a']--;
        }
        boolean isAnagram = true;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) {
                isAnagram = false;
            }
            alph[i] = 0;
        }
        return isAnagram;
    }


    //not correct when [a, b, a]
    static List<String> removeAnagrams1(String[] words) {
        Map<String, String> map = new LinkedHashMap<>();
        for (String word : words) {
            String wordSortedChars = rearrangeChars(word);
            if (!map.containsKey(wordSortedChars)) {
                map.put(wordSortedChars, word);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String rearrangeChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
