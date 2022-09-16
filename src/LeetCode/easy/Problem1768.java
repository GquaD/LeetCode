package LeetCode.easy;

public class Problem1768 {
    //https://leetcode.com/problems/merge-strings-alternately/
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    //Runtime: 1 ms, faster than 93.06% of Java online submissions for Merge Strings Alternately.
    //Memory Usage: 42.6 MB, less than 36.40% of Java online submissions for Merge Strings Alternately.
    static String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        String maxString = word1.length() > word2.length() ? word1 : word2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i))
                    .append(word2.charAt(i));
        }
        sb.append(maxString.substring(min));
        return sb.toString();
    }
}
