package LeetCode.easy;

public class Problem1768 {
    //https://leetcode.com/problems/merge-strings-alternately/
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    //3min
    //Runtime
    //1
    //ms
    //Beats
    //82.95%
    //Analyze Complexity
    //Memory
    //41.70
    //MB
    //Beats
    //71.53%
    public static String mergeAlternately(String word1, String word2) {
        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        while (a < word1.length() || b < word2.length()) {
            if (a < word1.length()) sb.append(word1.charAt(a++));
            if (b < word2.length()) sb.append(word2.charAt(b++));
        }
        return sb.toString();
    }

    //Runtime: 1 ms, faster than 93.06% of Java online submissions for Merge Strings Alternately.
    //Memory Usage: 42.6 MB, less than 36.40% of Java online submissions for Merge Strings Alternately.
    static String mergeAlternately1(String word1, String word2) {
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
