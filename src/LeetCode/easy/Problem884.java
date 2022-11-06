package LeetCode.easy;

import java.util.*;

public class Problem884 {
    //https://leetcode.com/problems/uncommon-words-from-two-sentences/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    //https://leetcode.com/problems/uncommon-words-from-two-sentences/solutions/2784153/java-100-time-95-memory-solution/
    //in 20 mins
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //40.8 MB
    //Beats
    //94.60%
    static String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String key : arr1) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();
        String[] arr2 = s2.split(" ");
        for (String key : arr2) {
            if (map2.containsKey(key)) {
                map2.put(key, map2.get(key) + 1);
            } else {
                map2.put(key, 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1 && !map2.keySet().contains(key)) {
                result.add(key);
            }
        }
        for (String key : map2.keySet()) {
            if (map2.get(key) == 1 && !map.keySet().contains(key)) {
                result.add(key);
            }
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    //incorrect
    static String[] uncommonFromSentences1(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String w : arr1) {
            set.add(w);
        }
        String[] arr2 = s2.split(" ");
        for (String w : arr2) {
            if (!set.contains(w)) {
                result.add(w);
            }
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
