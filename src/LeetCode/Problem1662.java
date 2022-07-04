package LeetCode;

public class Problem1662 {
    //https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"},
                new String[]{"a", "bc"}));
    }
    //Runtime: 1 ms, faster than 93.57% of Java online submissions for Check If Two String Arrays are Equivalent.
    //Memory Usage: 41.3 MB, less than 79.27% of Java online submissions for Check If Two String Arrays are Equivalent.
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s: word1) {
            sb1.append(s);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String s: word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
