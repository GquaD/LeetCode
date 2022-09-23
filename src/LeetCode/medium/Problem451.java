package LeetCode.medium;


import java.util.*;
import java.util.stream.Collectors;

public class Problem451 {
    //https://leetcode.com/problems/sort-characters-by-frequency/

    public static void main(String[] args) {

    }

    //30 mins since didn't take into account extra conditions in description of the tast
    //https://leetcode.com/problems/sort-characters-by-frequency/discuss/2613893/Java-Solution-in-24ms
    //Runtime: 24 ms, faster than 68.38% of Java online submissions for Sort Characters By Frequency.
    //Memory Usage: 45.6 MB, less than 84.04% of Java online submissions for Sort Characters By Frequency
    static String frequencySort(String s) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).freq++;
            } else {
                Pair pair = new Pair(c, 1);
                map.put(c, pair);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Pair> pairs = new ArrayList<>(map.values());
        Collections.sort(pairs, (o1, o2) -> o2.freq - o1.freq);
        for (Pair key : pairs) {
            for (int i = 0; i < key.freq; i++) {
                sb.append(key.character);
            }
        }
        return sb.toString();
    }

    static class Pair {
        char character;
        int freq;

        public Pair(char character, int freq) {
            this.character = character;
            this.freq = freq;
        }
    }

    //since all chars: Capital, lowercase and digits are used, I need to change algo

    static String frequencySort1(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < 26) {
            int idx = findMaxIdx(chars);
            if (idx == -1) break;
            int num = chars[idx];
            chars[idx] = 0;
            for (int i = 0; i < num; i++) {
                char toAdd = (char) ('a' + idx);
                sb.append(toAdd);
            }
            count++;
        }
        return sb.toString();
    }

    private static int findMaxIdx(int[] chars) {
        int maxIdx = -1;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (max < chars[i]) {
                max = chars[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
