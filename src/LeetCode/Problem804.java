package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem804 {
    //https://leetcode.com/problems/unique-morse-code-words/
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations1(new String[] {"gin","zen","gig","msg"}));
        System.out.println(uniqueMorseRepresentations1(new String[] {"a"}));
    }
    //Runtime: 3 ms, faster than 79.27% of Java online submissions for Unique Morse Code Words.
    //Memory Usage: 41.8 MB, less than 76.93% of Java online submissions for Unique Morse Code Words.
    static int uniqueMorseRepresentations1(String[] words) {
        String[] alphabet = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //use set
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(alphabet[word.charAt(i) - 97]);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }
        return set.size();
    }
    //Runtime: 6 ms, faster than 21.87% of Java online submissions for Unique Morse Code Words.
    //Memory Usage: 42.2 MB, less than 42.48% of Java online submissions for Unique Morse Code Words.
    static int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //use set
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(alphabet[word.charAt(i) - 97]);
            }
            if (map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            } else {
                map.put(sb.toString(), 1);
            }
            sb.setLength(0);
        }
        return map.keySet().size();
    }
}
