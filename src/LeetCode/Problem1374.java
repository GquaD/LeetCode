package LeetCode;

public class Problem1374 {
    //https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 95.98% of Java online submissions for Generate a String With Characters That Have Odd Counts.
    //Memory Usage: 41.7 MB, less than 55.45% of Java online submissions for Generate a String With Characters That Have Odd Counts.
    static String generateTheString(int n) {
        if (n == 0) return "";
        if (n == 1) return "a";
        if (n == 2) return "ab";
        if (n == 3) return "abc";
        if (n % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - 2; i++) {
                sb.append("a");
            }
            sb.append("bc");
            return sb.toString();
        }
    }
}
