package LeetCode.easy;

public class Problem2185 {
    //https://leetcode.com/problems/counting-words-with-a-given-prefix/
    public static void main(String[] args) {

    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Counting Words With a Given Prefix.
    //Memory Usage: 43.9 MB, less than 21.76% of Java online submissions for Counting Words With a Given Prefix.
    static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
