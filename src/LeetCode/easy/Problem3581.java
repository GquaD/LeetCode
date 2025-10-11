package LeetCode.easy;

public class Problem3581 {
    //https://leetcode.com/problems/count-odd-letters-from-number/
    //Runtime
    //1
    //ms
    //Beats
    //97.37%
    //Analyze Complexity
    //Memory
    //41.11
    //MB
    //Beats
    //52.63%
    //5min
    public int countOddLetters(int n) {
        int[] alph = new int[26];
        while (n > 0) {
            String word = getWord(n % 10);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                alph[c - 'a']++;
            }
            n /= 10;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (alph[i] % 2 == 1) result++;
        }

        return result;
    }

    private String getWord(int n) {
        switch (n) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }

    }
}
