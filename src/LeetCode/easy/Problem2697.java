package LeetCode.easy;

public class Problem2697 {
    //https://leetcode.com/problems/lexicographically-smallest-palindrome/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/lexicographically-smallest-palindrome/solutions/3560332/java-10-ms-o-n-solution/
    //5 min
    //Runtime
    //10 ms
    //Beats
    //89.43%
    //Memory
    //44.3 MB
    //Beats
    //84.23%
    static String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int half = arr.length / 2;
        for (int i = 0; i < half; i++) {
            char a = arr[i], b = arr[arr.length - i - 1];
            if (a < b) arr[arr.length - i - 1] = a;
            else if (a > b) arr[i] = b;
        }
        return new String(arr);
    }
}
