package LeetCode.easy;

public class Problem1119 {
    //https://leetcode.com/problems/remove-vowels-from-a-string/
    public static void main(String[] args) {
        System.out.println("ltcdscmmntyfrcdrs".equals(removeVowels("leetcodeisacommunityforcoders")));
        System.out.println("".equals(removeVowels("aeiou")));
    }

    //https://leetcode.com/problems/remove-vowels-from-a-string/solutions/4776342/java-o-n-100-faster/
    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.17
    //MB
    //Beats
    //85.86%
    //of users with Java
    static String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (!isVowel(s.charAt(i))) sb.append(s.charAt(i));
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
