package LeetCode.medium;

import java.util.Stack;

public class Problem394 {
    //https://leetcode.com/problems/decode-string/
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); //"zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
    }

    static String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strings = new Stack<>();
        StringBuilder sbNum = new StringBuilder();
        StringBuilder sbString = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c - 48 <= 9) {
                sbNum.append(c);
                continue;
            }
            if (c == '[') {
                nums.push(Integer.parseInt(sbNum.toString()));
                sbNum.setLength(0);
                if (sbString.length() > 0) {
                    strings.push(sbString.toString());
                }
                sbString.setLength(0);
                continue;
            }
            if (c == ']') {
                int num = nums.pop();
                String temp = sbString.toString();
                for (int i = 0; i < num - 1; i++) {
                    sbString.append(temp);
                }
                if (strings.size() == 0) {
                    sbResult.append(sbString.toString());
                    sbString.setLength(0);
                } else {
                    String t = strings.pop() + sbString.toString();
                    sbString.setLength(0);
                    sbString.append(t);
                }
                continue;
            }
            sbString.append(c);
        }
        return sbResult.append(sbString.toString()).toString();
    }
}
