package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1930 {
    //https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("kpokmnxyeehevqwymfjoqkmsleoufafhuoumnogozottlfltqgwagwcwdvftrwplquvuonpezhoynxvdtkbhrsddigvkdqqjbutktswlmpwwczqswukzvmihodwuxtbqvayelzlzxwhwwcjcrqbqstlccfcpnlaidwsmfcucjhjvwqrbopejftxqlfxddsjlugqgpshyawwfpekquugkgqbxajikvkoemzbpafxykhstlkqndccxzeiptqqilyggydpbrreadamjnvgjtwtdxilngzqmnbweeuxrctawabjxeyausrfgxivodrbfnbkwwuicljhutgjzzutoudyaoqsaitjthfzkyzdhbgvkxltp"));
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    //https://leetcode.com/problems/unique-length-3-palindromic-subsequences/solutions/4416788/java-alphabet-array-hashset-explained/
    //15-20min
    //Runtime
    //234 ms
    //Beats
    //26.75%
    //Memory
    //44.3 MB
    //Beats
    //60.78%
    static int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int freq = alph[i];
            if (freq == 0) continue;
            char a = (char) ('a' + i);
            if (freq >= 3) {
                sb.append(a).append(a).append(a);
                set.add(sb.toString());
                sb.setLength(0);
            }
            for (int j = 0; j < 26; j++) {
                if (i == j) continue;
                int freq2 = alph[j];
                if (freq2 == 0) continue;
                char b = (char) ('a' + j);
                if (freq > 1) {
                    sb.append(a).append(b).append(a);
                    set.add(sb.toString());
                    sb.setLength(0);
                }
                if (freq2 > 1) {
                    sb.append(b).append(a).append(b);
                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        int count = 0;
        for (String comb : set) {
            int idx = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == comb.charAt(idx)) {
                    idx++;
                }
                if (idx == 3) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
