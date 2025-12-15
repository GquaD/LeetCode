package LeetCode.medium;

public class Problem3775 {
    //Runtime
    //62
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //58.58
    //MB
    //Beats
    //-%
    //10min
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        int count = countVowels(split[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            String word = split[i];
            int vowels = countVowels(word);
            if (vowels == count) split[i] = sb.append(word).reverse().toString();
            sb.setLength(0);
        }

        for (String word: split) {
            sb.append(word).append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
