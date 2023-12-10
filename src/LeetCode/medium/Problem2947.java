package LeetCode.medium;

public class Problem2947 {
    //https://leetcode.com/problems/count-beautiful-substrings-i/
    public static void main(String[] args) {
        System.out.println(beautifulSubstrings("pulorolqcvhafexui", 9));
        System.out.println(beautifulSubstrings("abba", 1));
        System.out.println(beautifulSubstrings("baeyh", 2));
        System.out.println(beautifulSubstrings("bcdf", 1));
        System.out.println(beautifulSubstrings("baeyh", 3));
    }

    //Time Limit Exceeded
    //594 / 619 testcases passed
    static int beautifulSubstrings(String s, int k) {
        int minSize = Math.max(2, (int) Math.sqrt(k) + 1), count = 0, size = minSize;
        for (int i = size; i <= s.length(); i += minSize) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isBeautiful(s.substring(j, j + i), k)) count++;
            }
        }
        return count;
    }

    private static boolean isBeautiful(String s, int k) {
        int vowels = 0, cons = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) vowels++;
            else cons++;
        }
        return vowels == cons && (vowels * cons) % k == 0;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
