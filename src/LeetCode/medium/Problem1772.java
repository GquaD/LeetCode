package LeetCode.medium;

import java.util.*;

public class Problem1772 {
    //https://leetcode.com/problems/sort-features-by-popularity/

    //https://leetcode.com/problems/sort-features-by-popularity/solutions/5295487/java-100-faster-hashmap-solution/
    //1hour
    //Runtime
    //45
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //48.29
    //MB
    //Beats
    //39.39%
    //of users with Java
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> map = new HashMap<>();
        for (String r : responses) {
            String[] arr = r.split(" ");
            Set<String> set = new HashSet<>();
            for (String s : arr) {
                set.add(s);
            }
            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        Word[] arr = new Word[features.length];
        for (int i = 0; i < features.length; i++) {
            arr[i] = new Word(features[i], i, map.getOrDefault(features[i], 0));
        }

        Arrays.sort(arr, (a, b) -> b.freq == a.freq ? a.idx - b.idx : b.freq - a.freq);
        for (int i = 0; i < features.length; i++) {
            features[i] = arr[i].s;
        }
        return features;
    }


    private static String[] sortFeatures1(String[] features, String[] responses) {
        Word[] arr = new Word[features.length];
        for (int i = 0; i < features.length; i++) {
            Word word = new Word(features[i], i, 0);
            arr[i] = word;
            for (String r : responses) {
                if (r.contains(features[i] + " ") || r.contains(" " + features[i])) {
                    word.freq++;
                }
            }
        }
        Arrays.sort(arr, (a, b) -> b.freq == a.freq ? a.idx - b.idx : b.freq - a.freq);
        for (int i = 0; i < features.length; i++) {
            features[i] = arr[i].s;
        }
        return features;
    }


}

class Word {
    String s;
    int idx, freq;

    public Word(String s, int idx, int freq) {
        this.s = s;
        this.idx = idx;
        this.freq = freq;
    }
}
