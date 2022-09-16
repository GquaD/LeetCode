package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1832 {
    //https://leetcode.com/problems/check-if-the-sentence-is-pangram/submissions/
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));

    }
    //Runtime: 7 ms, faster than 10.64% of Java online submissions for Check if the Sentence Is Pangram.
    //Memory Usage: 42.1 MB, less than 48.12% of Java online submissions for Check if the Sentence Is Pangram.
    static boolean checkIfPangram(String sentence) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (map.get(sentence.charAt(i)) != null) {
                map.put(sentence.charAt(i), map.get(sentence.charAt(i)) + 1);
            } else {
                map.put(sentence.charAt(i), 1);
            }
            if (map.keySet().size() == 26) {
                return true;
            }
        }
        return false;
    }
}
