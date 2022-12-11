package LeetCode.easy;

public class Problem2496 {
    //https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/solutions/2900577/java-in-2ms/
    //Runtime
    //2 ms
    //Beats
    //83.33%
    //Memory
    //41.8 MB
    //Beats
    //66.67%
    static int maximumValue(String[] strs) {
        int max = 0;
        for (String s : strs) {
            boolean isNumber = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                int n = Integer.parseInt(s);
                if (max < n) {
                    max = n;
                }
            } else {
                if (max < s.length()) {
                    max = s.length();
                }
            }
        }
        return max;
    }

    static int maximumValue1(String[] strs) {
        int max = 0;
        for (String s : strs) {
            boolean isNumber = true;
            int n = 0;
            try {
                n = Integer.parseInt(s);
            } catch (Exception e) {
                isNumber = false;
            }
            if (isNumber) {
                if (max < n) {
                    max = n;
                }
            } else {
                if (max < s.length()) {
                    max = s.length();
                }
            }
        }
        return max;
    }


}
