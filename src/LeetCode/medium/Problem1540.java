package LeetCode.medium;

public class Problem1540 {
    //https://leetcode.com/problems/can-convert-string-in-k-moves/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/can-convert-string-in-k-moves/solutions/4456958/java-o-n-array-for-differences/
    //35 min
    //Runtime
    //8 ms
    //Beats
    //47.62%
    //Memory
    //45.6 MB
    //Beats
    //5.56%
    static boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int diff = s.charAt(i) - t.charAt(i);
            if (diff == 0) continue;

            diff = diff > 0 ? 26 - diff : -diff;

            if (arr[diff] > k) return false;
            arr[diff] += 26;
        }
        return true;
    }
}
