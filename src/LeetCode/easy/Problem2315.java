package LeetCode.easy;

public class Problem2315 {
    //https://leetcode.com/problems/count-asterisks/
    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    //Runtime: 5 ms, faster than 15.14% of Java online submissions for Count Asterisks.
    //Memory Usage: 42.4 MB, less than 35.53% of Java online submissions for Count Asterisks.
    static int countAsterisks(String s) {
        int countAsterisks = 0;
        boolean isValid = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                isValid = !isValid;
            }
            if (s.charAt(i) == '*' && isValid) {
                countAsterisks++;
            }
        }
        return countAsterisks;
    }
}
