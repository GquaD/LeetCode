package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem49 {
    //https://leetcode.com/problems/group-anagrams/

    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfStrings(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println("////////");
        LeetCodeUtils.printListWithListsOfStrings(groupAnagrams(new String[]{""}));
        System.out.println("////////");
        LeetCodeUtils.printListWithListsOfStrings(groupAnagrams(new String[]{"eat"}));
        System.out.println("////////");
        LeetCodeUtils.printListWithListsOfStrings(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat","bata"}));
    }

    //https://leetcode.com/problems/group-anagrams/solutions/2665998/java-three-approaches-to-one-solution/
    //Runtime
    //13 ms
    //Beats
    //69.39%
    //Memory
    //56.7 MB
    //Beats
    //32.56%
    static List<List<String>> groupAnagrams(String[] s) {
        if (s.length == 1) {
            List<String> list = new ArrayList<>(1);
            list.add(s[0]);
            List<List<String>> res = new ArrayList<>(1);
            res.add(list);
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : s) {
            char[] alphabet = new char[26];
            for (char c : word.toCharArray()) {
                alphabet[c - 'a']++;
            }
            String key = new String(alphabet);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    //Runtime
    //15 ms
    //Beats
    //48.52%
    //Memory
    //56 MB
    //Beats
    //46.8%
    static List<List<String>> groupAnagrams2(String[] s) {
        if (s.length == 1) {
            List<String> list = new ArrayList<>(1);
            list.add(s[0]);
            List<List<String>> res = new ArrayList<>(1);
            res.add(list);
            return res;
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : s) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    //20 mins
    //Runtime
    //44 ms
    //Beats
    //16.86%
    //Memory
    //57.2 MB
    //Beats
    //27.97%
    static List<List<String>> groupAnagrams1(String[] s) {
        if (s.length == 1) {
            List<String> list = new ArrayList<>(1);
            list.add(s[0]);
            List<List<String>> res = new ArrayList<>(1);
            res.add(list);
            return res;
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String word : s) {
            byte[] alphabet = new byte[26];
            for (char c : word.toCharArray()) {
                alphabet[c - 'a']++;
            }
            for (byte freq : alphabet) {
                sb.append(freq).append(",");
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key,list);
            }
            sb.setLength(0);
        }
        return new ArrayList<>(map.values());
    }
}
