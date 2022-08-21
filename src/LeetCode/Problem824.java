package LeetCode;

public class Problem824 {
    //https://leetcode.com/problems/goat-latin/
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin")
                .equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog")
                .equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    //Runtime: 2 ms, faster than 97.02% of Java online submissions for Goat Latin.
    //Memory Usage: 43.1 MB, less than 32.29% of Java online submissions for Goat Latin.
    static String toGoatLatin(String sentence) {
        String vowels = "aeiou";
        String vowelsCap = "AEIOU";
        String[] words = sentence.split(" ");
        StringBuilder aaa = new StringBuilder();
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            aaa.append("a");
            if (vowels.contains(word.charAt(0) + "") || vowelsCap.contains(word.charAt(0) + "")) {
                current.append(word);
            } else {
                current.append(word.substring(1)).append(word.substring(0, 1));
            }
            current.append("ma").append(aaa);
            result.append(current).append(" ");
            current.setLength(0);
        }
        return result.toString().trim();
    }
}
