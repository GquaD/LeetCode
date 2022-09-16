package LeetCode.easy;

public class Problem2278 {
    //https://leetcode.com/problems/percentage-of-letter-in-string/
    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
        System.out.println(percentageLetter("jjjj", 'k'));
    }

    //Runtime: 1 ms, faster than 46.30% of Java online submissions for Percentage of Letter in String.
    //Memory Usage: 42.7 MB, less than 5.05% of Java online submissions for Percentage of Letter in String.
    static int percentageLetter(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return (count * 100 / s.length());
    }
}
