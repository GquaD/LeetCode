package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
    //https://leetcode.com/problems/palindrome-number/
    public static void main(String[] args) {

    }

    //20mins
    //https://leetcode.com/problems/palindrome-number/solutions/2650768/java-3-solutions-from-slowest-to-fastest/

    //Runtime
    //10 ms
    //Beats
    //89.71%
    //Memory
    //41.7 MB
    //Beats
    //92.85%
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //25% / 25% result
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
