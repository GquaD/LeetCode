package LeetCode.easy;

public class Problem3856 {
    //2min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.09
    //MB
    //Beats
    //100.00%
    public String trimTrailingVowels(String s) {
        int idx = s.length();
        while (idx - 1 >= 0 && isVowel(s.charAt(idx - 1))) idx--;
        return s.substring(0, idx);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
