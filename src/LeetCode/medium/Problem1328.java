package LeetCode.medium;

public class Problem1328 {
    //https://leetcode.com/problems/break-a-palindrome/
    public static void main(String[] args) {
        System.out.println(breakPalindrome("b"));
        System.out.println(breakPalindrome("aaa"));
        System.out.println(breakPalindrome("aba"));
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("a"));
    }


    //20 min
    //Runtime
    //136 ms
    //Beats
    //5.43%
    //Memory
    //40.6 MB
    //Beats
    //68.57%
    static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        StringBuilder sb = new StringBuilder();
        int countA = 0;
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != 'a') {
                if (palindrome.length() % 2 == 1 && i == palindrome.length() / 2) {
                    continue;
                }
                sb.append(palindrome.substring(0, i));
                sb.append('a');
                sb.append(palindrome.substring(i + 1));
                return sb.toString();
            } else countA++;
        }
        if (countA != 1 && (countA == palindrome.length() || palindrome.length() % 2 == 1 && palindrome.length() - 1 == countA)) {
            sb.append(palindrome.substring(0, palindrome.length() - 1));
            sb.append('b');
            return sb.toString();
        }
        return "";
    }
}
