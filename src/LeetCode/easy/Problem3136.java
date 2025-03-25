package LeetCode.easy;

public class Problem3136 {
    //https://leetcode.com/problems/valid-word
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-word/solutions/6577926/java-straightforward-solution-by-tbekpro-v4ln/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //99.43%
    //Analyze Complexity
    //Memory
    //41.83
    //MB
    //Beats
    //88.13%
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        word = word.toLowerCase();
        int vowel = 0, conso = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '@' || c == '#' || c == '$') {
                return false;
            } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else if (!(c >= '0' && c <= '9')) {
                conso++;
            }
        }
        return vowel > 0 && conso > 0;
    }
}
