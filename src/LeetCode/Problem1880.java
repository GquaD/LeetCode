package LeetCode;

public class Problem1880 {
    //https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
    public static void main(String[] args) {
        System.out.println(isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual("aaa", "a", "aab"));
        System.out.println(isSumEqual("aaa", "a", "aaaa"));
    }

    //Runtime: 1 ms, faster than 69.14% of Java online submissions for Check if Word Equals Summation of Two Words.
    //Memory Usage: 42.6 MB, less than 13.38% of Java online submissions for Check if Word Equals Summation of Two Words.
    static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {
            sb.append(firstWord.charAt(i) - 97);
        }
        int first = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < secondWord.length(); i++) {
            sb.append(secondWord.charAt(i) - 97);
        }
        int second = Integer.parseInt(sb.toString());
        sb.setLength(0);
        for (int i = 0; i < targetWord.length(); i++) {
            sb.append(targetWord.charAt(i) - 97);
        }
        int target = Integer.parseInt(sb.toString());
        return first + second == target;
    }
}
