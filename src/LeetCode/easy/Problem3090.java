package LeetCode.easy;

public class Problem3090 {
    //https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
    public static void main(String[] args) {

    }

    //5-10min
    //Runtime
    //180
    //ms
    //Beats
    //5.00%
    //Analyze Complexity
    //Memory
    //42.50
    //MB
    //Beats
    //59.37%
    public int maximumLengthSubstring(String s) {
        int max = 0, arr[] = new int[26];
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (atMostTwo(s, i, j, arr)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    private boolean atMostTwo(String s, int start, int end, int[] arr) {
        for (int i = start; i <= end; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        boolean result = true;
        for (int freq: arr) {
            if (freq > 2) {
                result = false;
                break;
            }
        }

        for (int i = 0; i < 26; i++) arr[i] = 0;
        return result;
    }
}
