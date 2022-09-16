package LeetCode.easy;

public class Problem1816 {
    //https://leetcode.com/problems/truncate-sentence/
    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }
    //Runtime: 1 ms, faster than 91.45% of Java online submissions for Truncate Sentence.
    //Memory Usage: 43.2 MB, less than 18.94% of Java online submissions for Truncate Sentence.
    static String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        if (words.length == k) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
