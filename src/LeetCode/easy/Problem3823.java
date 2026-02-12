package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3823 {
    //10 min
    //Runtime
    //3
    //ms
    //Beats
    //57.70%
    //Analyze Complexity
    //Memory
    //46.69
    //MB
    //Beats
    //22.66%

    public String reverseByType(String s) {
        List<Character> letters = new ArrayList<>(), specials = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) letters.add(c);
            else specials.add(c);
        }

        StringBuilder sb = new StringBuilder();
        int l = letters.size() - 1, sp = specials.size() - 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) sb.append(letters.get(l--));
            else sb.append(specials.get(sp--));
        }

        return sb.toString();
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
