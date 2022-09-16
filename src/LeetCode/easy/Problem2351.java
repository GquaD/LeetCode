package LeetCode.easy;

public class Problem2351 {
    //https://leetcode.com/problems/first-letter-to-appear-twice/
    public static void main(String[] args) {
        System.out.println(repeatedCharacter("abccbaacz"));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for First Letter to Appear Twice.
    //Memory Usage: 42 MB, less than 96% of Java online submissions for First Letter to Appear Twice.
    static char repeatedCharacter(String s) {
        boolean[] letters = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (letters[idx]) {
                return s.charAt(i);
            }
            letters[idx] = true;
        }
        return ' ';
    }
}
