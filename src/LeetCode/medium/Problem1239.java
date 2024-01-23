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

//        List<String> words1 = new ArrayList<>();
//        words1.add("aa");
//        words1.add("bb");
//        System.out.println(maxLength(words1));
//        System.out.println("////////////////");
//        List<String> words2 = new ArrayList<>();
//        words2.add("zog");
//        words2.add("nvwsuikgndmfexxgjtkb");
//        words2.add("nxko");
//        System.out.println(maxLength(words2));
//        System.out.println("////////////////");
//        List<String> words3 = new ArrayList<>();
//        words3.add("abc");
//        words3.add("ab");
//        words3.add("cd");
//        words3.add("efg");
//        words3.add("ef");
//        words3.add("gh");
//        System.out.println(maxLength(words3));
        System.out.println("////////////////");
        List<String> words4 = new ArrayList<>();
        words4.add("abcdefghijklmnopqrstuvwxyz");
        System.out.println(maxLength(words4));
        System.out.println("////////////////");
    }


    //https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solutions/4614075/java-backtracking-solution/
    //20 - 25 min
    //Runtime
    //7
    //ms
    //Beats
    //89.11%
    //of users with Java
    //Memory
    //45.02
    //MB
    //Beats
    //25.40%
    //of users with Java

    static int[] alph;

    static int maxLength(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        int[] res = new int[1];
        goBacktracking(0, arr, sb, res);
        return res[0];
    }
    private static void goBacktracking(int i, List<String> arr, StringBuilder sb, int[] res) {
        if (i >= arr.size()) return;

        int len = sb.length();
        sb.append(arr.get(i));

        if (hasUniqueChars(sb)) {
            res[0] = Math.max(res[0], sb.length());
            goBacktracking(i + 1, arr, sb, res);
        }

        sb.setLength(len);
        goBacktracking(i + 1, arr, sb, res);
    }

    private static boolean hasUniqueChars(StringBuilder sb) {
        if (alph == null) alph = new int[26];
        else for (int i = 0; i < 26; i++) alph[i] = 0;


        for (int i = 0; i < sb.length(); i++) {
            if (++alph[sb.charAt(i) - 'a'] > 1) return false;
        }

        return true;
    }


    //not correct 85/89
    static int maxLength1(List<String> list) {
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
