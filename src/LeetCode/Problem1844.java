package LeetCode;

public class Problem1844 {
    //https://leetcode.com/problems/replace-all-digits-with-characters/
    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1"));
        System.out.println(replaceDigits("a1b2c3d4e"));
    }

    //Runtime: 3 ms, faster than 30.65% of Java online submissions for Replace All Digits with Characters.
    //Memory Usage: 42.5 MB, less than 27.68% of Java online submissions for Replace All Digits with Characters.
    static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            char c = shift(s.charAt(i - 1), Integer.parseInt(s.charAt(i) + ""));
            sb.append(s.charAt(i - 1)).append(c);
        }
        if (s.length() % 2 == 1) {
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }

    private static char shift(char charAt, int num) {
        return (char) (charAt + num);
    }
}
