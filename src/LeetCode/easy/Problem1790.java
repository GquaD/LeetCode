package LeetCode.easy;

public class Problem1790 {
    //https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/solutions/6379158/java-100-faster-solution-by-tbekpro-t6u0/
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.62
    //MB
    //Beats
    //58.39%
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        char a = ' ', b = ' ';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == ' ') {
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                } else if (count == 1) {
                    if (s2.charAt(i) != a || s1.charAt(i) != b) {
                        return false;
                    }
                } else {
                    return false;
                }
                count++;
            }
        }
        return count == 0 || count == 2;
    }
}
