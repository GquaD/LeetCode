package LeetCode.easy;

public class Problem2586 {
    //https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
    public static void main(String[] args) {

    }

    //Runtime
    //1 ms
    //Beats
    //100%
    //Sorry, there are not enough accepted submissions to show data
    //Memory
    //42.6 MB
    //Beats
    //100%
    static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) count++;
        return count;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
