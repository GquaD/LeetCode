package LeetCode.easy;

public class Problem1678 {
    //https://leetcode.com/problems/goal-parser-interpretation/
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Goal Parser Interpretation.
    //Memory Usage: 40.5 MB, less than 92.70% of Java online submissions for Goal Parser Interpretation.
    static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else if (command.charAt(i + 1) == 'a'){
                    sb.append("al");
                    i += 3;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
