package LeetCode;

public class Problem1614 {
    //https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    //Runtime: 1 ms, faster than 88.84% of Java online submissions for Maximum Nesting Depth of the Parentheses.
    //Memory Usage: 42.1 MB, less than 52.11% of Java online submissions for Maximum Nesting Depth of the Parentheses.
    static int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
