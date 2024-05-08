package LeetCode.medium;

public class Problem2083 {
    //https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter

    //https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/solutions/5129791/java-o-n-solution/
    //2min
    //Runtime
    //4
    //ms
    //Beats
    //53.49%
    //of users with Java
    //Memory
    //44.40
    //MB
    //Beats
    //93.02%
    //of users with Java
    long numberOfSubstrings(String s) {
        long[] arr = new long[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        long res = s.length();
        for (long freq : arr) {
            res += (freq * (freq - 1L)) / 2L;
        }
        return res;
    }
}
