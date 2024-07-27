package LeetCode.easy;

public class Problem266 {
    //https://leetcode.com/problems/palindrome-permutation
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/palindrome-permutation/solutions/5544139/java-fastest-o-n-o-1-solution/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.04
    //MB
    //Beats
    //77.91%
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) odd++;
        }
        return odd <= 1;
    }
}
