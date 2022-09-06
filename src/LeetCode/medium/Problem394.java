package LeetCode.medium;

import java.util.Stack;

public class Problem394 {
    //https://leetcode.com/problems/decode-string/
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); //"zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
        System.out.println("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkef"=="zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
    }


    //Runtime: 2 ms, faster than 59.96% of Java online submissions for Decode String.
    //Memory Usage: 41.5 MB, less than 82.55% of Java online submissions for Decode String
    static String decodeString(String s) {
        Stack<Character> stackBraces = new Stack<>();
        Stack<Integer> stackMultipliers = new Stack<>();
        Stack<String> stackString = new Stack<>();

        StringBuilder sbResult = new StringBuilder();
        StringBuilder string = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c - 48 <= 9) {
                num.append(c);
                continue;
            }
            if (!num.toString().equals("")) {
                stackMultipliers.push(Integer.parseInt(num.toString()));
                num.setLength(0);
            }

            if (c == '[') {
                stackString.push(string.toString());
                string.setLength(0);
                stackBraces.push(c);
                continue;
            }

            if (c == ']') {
                stackBraces.pop();

                String tempStr = stackString.pop();
                int tempInt = stackMultipliers.pop();
                StringBuilder tempSB = new StringBuilder();
                for (int i = 0; i < tempInt; i++) {
                    tempSB.append(string);
                }
                String tempStrForNow = tempStr + tempSB.toString();
                if (string.toString().equals("")) {
                    stackString.push(tempStrForNow);
                }
                string.setLength(0);
                if (stackBraces.size() == 0) {
                    sbResult.append(tempStrForNow);
                } else {
                    string.append(tempStrForNow);
                }
                continue;
            }
            string.append(c);
        }
        if (string.length() > 0) {
            sbResult.append(string);
        }
        return sbResult.toString();
    }

    static String decodeString1(String s) {
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
