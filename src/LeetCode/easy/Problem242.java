package LeetCode.easy;

public class Problem242 {
    //https://leetcode.com/problems/valid-anagram/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-anagram/solutions/2813081/java-100-faster-o-n-solution-explained/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //94.63%
    static boolean isAnagram1(String s, String t) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        for (int n : a) {
            if (n != 0) return false;
        }
        return true;
    }

    //3 mins
    //Runtime
    //2 ms
    //Beats
    //99.14%
    //Memory
    //42.2 MB
    //Beats
    //94.63%
    static boolean isAnagram(String s, String t) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alph[t.charAt(i) - 'a']--;
        }
        for (int n : alph) {
            if (n != 0) return false;
        }
        return true;
    }
}
