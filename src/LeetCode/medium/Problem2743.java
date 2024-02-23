package LeetCode.medium;

public class Problem2743 {
    //https://leetcode.com/problems/count-substrings-without-repeating-character/
    public static void main(String[] args) {
        System.out.println(numberOfSpecialSubstrings("ooo"));
        System.out.println(numberOfSpecialSubstrings("abab"));
        System.out.println(numberOfSpecialSubstrings("afiau"));
        System.out.println(numberOfSpecialSubstrings("abcd"));
    }

    //50min
    //Runtime
    //92
    //ms
    //Beats
    //58.82%
    //of users with Java
    //Memory
    //45.22
    //MB
    //Beats
    //86.76%
    //of users with Java
    static int numberOfSpecialSubstrings(String s) {
        int[] alph = new int[26];
        int res = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            alph[s.charAt(r) - 'a']++;
            while (!allUnique(alph)) {
                alph[s.charAt(l) - 'a']--;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }

    private static boolean allUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) return false;
        }
        return true;
    }

    static int numberOfSpecialSubstrings1(String s) {
        int[] alph = new int[26];
        int res = s.length(), count = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;

            if (!allUnique(alph))
                res += ((count - 1) * count) / 2;
            count++;

            while (!allUnique(alph)) {
                alph[s.charAt(j++) - 'a']--;
                count--;
            }
        }
        if (allUnique(alph))
            res += ((count - 1) * count) / 2;
        return res;
    }
}
