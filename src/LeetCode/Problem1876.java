package LeetCode;

public class Problem1876 {
    //https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    //Runtime: 2 ms, faster than 67.73% of Java online submissions for Substrings of Size Three with Distinct Characters.
    //Memory Usage: 42.2 MB, less than 56.47% of Java online submissions for Substrings of Size Three with Distinct Characters.
    static int countGoodSubstrings(String s) {
        int countUnique = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                countUnique++;
            }
        }
        return countUnique;
    }

    //Runtime: 2 ms, faster than 67.73% of Java online submissions for Substrings of Size Three with Distinct Characters.
    //Memory Usage: 42.8 MB, less than 29.58% of Java online submissions for Substrings of Size Three with Distinct Characters.
    static int countGoodSubstrings1(String s) {
        int countUnique = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            String temp = s.substring(i, i + 3);
            if (temp.charAt(0) != temp.charAt(1)
                    && temp.charAt(0) != temp.charAt(2)
                    && temp.charAt(1) != temp.charAt(2)) {
                countUnique++;
            }
        }
        return countUnique;
    }
}
