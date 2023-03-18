package LeetCode.easy;

import java.util.Arrays;

public class Problem2559 {
    //https://leetcode.com/problems/count-vowel-strings-in-ranges/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(vowelStrings(new String[]{"e","a","e"}, new int[][]{{0,2},{0,1},{2,2}})));
        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}})));
    }

    //https://leetcode.com/problems/count-vowel-strings-in-ranges/solutions/3310467/java-4ms-using-count-array/
    //40 min
    //Runtime
    //4 ms
    //Beats
    //95.4%
    //Memory
    //83.4 MB
    //Beats
    //22.81%
    static int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        arr[0] = isVowelWord(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) arr[i] = isVowelWord(words[i]) ? arr[i - 1] + 1 : arr[i - 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            res[i] = start == 0 ? arr[end] : arr[end] - arr[start - 1];
        }
        return res;
    }

    //TLE on 92/93
    static int[] vowelStrings1(String[] words, int[][] queries) {
        boolean[] vowel = new boolean[words.length];
        for (int i = 0; i < words.length; i++) vowel[i] = isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1));
        int[] arr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            for (int j = start; j <= end; j++) if (vowel[j]) arr[i]++;
        }
        return arr;
    }

    private static boolean isVowelWord(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
