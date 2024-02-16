package LeetCode.medium;

public class Problem1100 {
    //https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/solutions/4737199/java-o-n-solution/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //93.68%
    //of users with Java
    //Memory
    //41.64
    //MB
    //Beats
    //80.77%
    //of users with Java
    static int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;
        int j = 0, count = 0, alph[] = new int[26];
        for (int i = 0; i < k; i++) {
            alph[s.charAt(i) - 'a']++;
        }
        if (hasUniqueChars(alph)) count++;
        for (int i = k; i < s.length(); i++) {
            alph[s.charAt(j++) - 'a']--;
            alph[s.charAt(i) - 'a']++;
            if (hasUniqueChars(alph)) count++;
        }
        return count;
    }

    private static boolean hasUniqueChars(int[] arr) {
        for (int a : arr) {
            if (a > 1) return false;
        }
        return true;
    }
}
