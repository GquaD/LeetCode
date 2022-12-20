package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem893 {
    //https://leetcode.com/problems/groups-of-special-equivalent-strings/
    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
        System.out.println(numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }

    //
    //20-25 min
    //Runtime
    //8 ms
    //Beats
    //91.72%
    //Memory
    //42 MB
    //Beats
    //94.27%
    static int numSpecialEquivGroups(String[] words) {
        if (words.length == 1) return 1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(findAlphabet(words[i]));
        }
        return set.size();
    }

    private static String findAlphabet(String word) {
        byte[][] alph = new byte[2][26];
        for (int i = 0; i < word.length(); i+=2) {
            alph[0][word.charAt(i) - 'a']++;
        }
        for (int i = 1; i < word.length(); i+=2) {
            alph[1][word.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alph[0][i]);
            sb.append(alph[1][i]);
        }
        return sb.toString();
    }
}
