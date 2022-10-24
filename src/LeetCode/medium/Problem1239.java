package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1239 {
    //https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("un");
        words.add("iq");
        words.add("ue");
        System.out.println(maxLength(words));
        System.out.println("////////////////");
        List<String> words1 = new ArrayList<>();
        words1.add("aa");
        words1.add("bb");
        System.out.println(maxLength(words1));
        System.out.println("////////////////");
        List<String> words2 = new ArrayList<>();
        words2.add("zog");
        words2.add("nvwsuikgndmfexxgjtkb");
        words2.add("nxko");
        System.out.println(maxLength(words2));
        System.out.println("////////////////");
        List<String> words3 = new ArrayList<>();
        words3.add("abc");
        words3.add("ab");
        words3.add("cd");
        words3.add("efg");
        words3.add("ef");
        words3.add("gh");
        System.out.println(maxLength(words3));
        System.out.println("////////////////");
        List<String> words4 = new ArrayList<>();
        words4.add("abcdefghijklmnopqrstuvwxyz");
        System.out.println(maxLength(words4));
        System.out.println("////////////////");
    }


    //not correct 85/89
    static int maxLength(List<String> list) {
        boolean[] alphabet = new boolean[26];
        list.sort((o1, o2) -> o2.length() - o1.length());
        int result = 0;

        for (int k = 0; k < list.size(); k++) {
            String w = list.get(k);
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                if (!alphabet[ch - 'a']) {
                    alphabet[ch - 'a'] = true;
                } else {
                    for (int j = 0; j < i; j++) {
                        char c = w.charAt(j);
                        alphabet[c - 'a'] = false;
                    }
                    break;
                }
            }
            if (k + 1 < list.size()) {
                for (int i = k + 1; i < list.size(); i++) {
                    if (i == k) continue;
                    String word = list.get(i);
                    boolean isUnique = true;
                    int idxNotUnique = -1;
                    for (int j = 0; j < word.length(); j++) {
                        char c = word.charAt(j);
                        if (alphabet[c - 'a']) {
                            isUnique = false;
                            idxNotUnique = j;
                            break;
                        } else {
                            alphabet[c - 'a'] = true;
                        }
                    }
                    if (!isUnique) {
                        for (int j = 0; j < idxNotUnique; j++) {
                            char c = word.charAt(j);
                            alphabet[c - 'a'] = false;
                        }
                    }
                }
            }
            int count = countUnique(alphabet);
            if (result < count) result = count;
            for (int j = 0; j < alphabet.length; j++) {
                alphabet[j] = false;
            }
        }

        return result;
    }

    private static int countUnique(boolean[] alphabet) {
        int count = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i]) count++;
        }
        return count;
    }
}
