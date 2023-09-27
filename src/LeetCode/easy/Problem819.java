package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem819 {
    //https://leetcode.com/problems/most-common-word/
    public static void main(String[] args) {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",
                new String[]{"a"}));
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));

    }

    //15 min
    //Runtime
    //15 ms
    //Beats
    //56.38%
    //Memory
    //43.7 MB
    //Beats
    //25.27%
    static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String[] s = paragraph.split("\\W+");
        StringBuilder sb = new StringBuilder();
        for (String word : s) {
            for (int i = 0; i < word.length(); i++) if (Character.isLetter(word.charAt(i))) sb.append(word.charAt(i));
            String myWord = sb.toString();
            sb.setLength(0);
            if (myWord.length() > 0) map.put(myWord, map.getOrDefault(myWord, 0) + 1);
        }
        for (String ban : banned) map.remove(ban);
        int max = 0;
        String word = "";
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (freq > max) {
                max = freq;
                word = key;
            }
        }
        return word;
    }
}
