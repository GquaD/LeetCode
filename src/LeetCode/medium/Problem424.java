package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem424 {
    //https://leetcode.com/problems/longest-repeating-character-replacement/
    public static void main(String[] args) {

    }

    //Runtime: 7 ms, faster than 81.51% of Java online submissions for Longest Repeating Character Replacement.
    //Memory Usage: 43.3 MB, less than 47.05% of Java online submissions for Longest Repeating Character Replacement.
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    //wrong
    static int characterReplacement2(String s, int k) {
        List<Pair> list = makeListOfPairs(s);
        Pair longest = findMaxNumber(list);
        for (int i = 0; i < k; i++) {
            String left = moveLeft(longest, s);
            String right = moveRight(longest, s);
        }
        return 0;
    }

    private static String moveLeft(Pair longest, String s) {
        StringBuilder sb = new StringBuilder();
        int len = longest.numberInSequence;
        if (longest.indexStart - 2 >= 0 && s.charAt(longest.indexStart - 2) == longest.character) {
            len += 2;
        } else {
            len++;
        }
        for (int i = 0; i < len; i++) {
            sb.append(longest.character);
        }
        return sb.toString();
    }

    private static String moveRight(Pair longest, String s) {
        StringBuilder sb = new StringBuilder();
        int len = longest.numberInSequence;
        if (longest.indexStart + 2 < s.length() && s.charAt(longest.indexStart + 2) == longest.character) {
            len += 2;
        } else {
            len++;
        }
        for (int i = 0; i < len; i++) {
            sb.append(longest.character);
        }
        return sb.toString();
    }

    private static List<Pair> makeListOfPairs(String s) {
        List<Pair> list = new ArrayList<>();
        Pair pair = new Pair();
        for (int i = 0; i < s.length(); i++) {
            if (pair.character == s.charAt(i)) {
                pair.indexStart = i;
                pair.numberInSequence++;
            } else {
                pair.indexEnd = i;
                list.add(pair);
                pair = new Pair();
                pair.character = s.charAt(i);
                pair.numberInSequence++;
                pair.indexStart = i;
            }
            if (i == s.length() - 1) {
                pair.indexEnd = i;
                list.add(pair);
            }
        }
        return list;
    }

    private static Pair findMaxNumber(List<Pair> list) {
        int max = 0;
        Pair pair = new Pair();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i).numberInSequence;
            if (max < num) {
                max = num;
                pair = list.get(i);
            }
        }
        return pair;
    }

    static class Pair {
        char character;
        int numberInSequence;
        int indexStart;
        int indexEnd;

        public char getCharacter() {
            return character;
        }

        public int getNumberInSequence() {
            return numberInSequence;
        }
    }
}
