package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem2283 {
    //https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/submissions/
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }

    //Runtime: 3 ms, faster than 38.68% of Java online submissions for Check if Number Has Equal Digit Count and Digit Value.
    //Memory Usage: 43.1 MB, less than 6.95% of Java online submissions for Check if Number Has Equal Digit Count and Digit Value.
    static boolean digitCount(String nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length(); i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < nums.length(); i++) {
            int cur = nums.charAt(i) - 48;
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        boolean res = true;
        for (int num = 0; num < nums.length(); num++) {
            if (map.get(num) != (nums.charAt(num) - 48)) {
                return false;
            }
        }
        return res;
    }
}
