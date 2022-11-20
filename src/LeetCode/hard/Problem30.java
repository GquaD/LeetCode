package LeetCode.hard;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem30 {
    //https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    public static void main(String[] args) {
        LeetCodeUtils.printList(findSubstring("ababababab", new String[]{"ababa","babab"}));
        LeetCodeUtils.printList(findSubstring("ababaab", new String[]{"ab","ba","ba"}));
        LeetCodeUtils.printList(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        LeetCodeUtils.printList(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }

    //https://leetcode.com/problems/substring-with-concatenation-of-all-words/solutions/2833905/java-hashmap-83-memory-solution/
    //Runtime
    //280 ms
    //Beats
    //51.95%
    //Memory
    //43.8 MB
    //Beats
    //81.28%
    static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int len = 0, wordLength = words[0].length();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
            len += word.length();
        }

        List<Integer> indices = new ArrayList<>();
        int times = s.length() - len;
        for (int i = 0; i <= times; i++) {
            if (map.isEmpty()) {
                for (String word : words) {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
            String sub = s.substring(i, i + len);
            int count = 0;
            while (count < words.length) {
                String word = sub.substring(0, wordLength);
                Integer freq = map.get(word);
                if (freq != null && freq > 0) {
                    map.put(word, freq - 1);
                    sub = sub.substring(wordLength);
                    count++;
                } else break;
            }
            if (count == words.length) {
                indices.add(i);
            }
            map.clear();
        }
        return indices;
    }

    static List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int len = 0;
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
            len += word.length();
        }

        Map<Integer, List<String>> mapFreq = new TreeMap<>(Collections.reverseOrder());
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (mapFreq.containsKey(freq)) {
                List<String> list = mapFreq.get(freq);
                list.add(key);
                list.sort(String::compareTo);
            } else {
                List<String> list = new ArrayList<>();
                list.add(key);
                mapFreq.put(freq, list);
            }
        }

        List<Integer> indices = new ArrayList<>();
        int times = s.length() - len;
        for (int i = 0; i <= times; i++) {
            String sub = s.substring(i, i + len);
            for (int freq : mapFreq.keySet()) {
                List<String> list = mapFreq.get(freq);
                for (int j = 0; j < list.size(); j++) {
                    String word = list.get(j);
                    for (int k = 0; k < freq; k++) {
                        if (!sub.contains(word)) {
                            break;
                        } else {
                            sub = sub.replaceFirst(word, "");
                        }
                    }
                }
            }
            if (sub.length() == 0) indices.add(i);
        }
        return indices;
    }

    static List<Integer> findSubstring1(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = -1, len = 0;
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
            if (min > word.length()) {
                min = word.length();
            }
            if (max < word.length()) {
                max = word.length();
            }
            len += word.length();
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            for (int j = 0; j < words.length; j++) {
                String word = words[i];
                if (!sub.contains(word)) {
                    break;
                } else {
                    sub.replaceFirst(word, "");
                }
            }
            if (sub.length() == 0) indices.add(i);
        }
        return indices;
    }
}
