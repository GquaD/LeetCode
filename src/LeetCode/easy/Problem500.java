package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem500 {
    static String first = "qwertyuiop";
    static String second = "asdfghjkl";
    //static String third = "zxcvbnm";

    //https://leetcode.com/problems/keyboard-row/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"omk"})));

    }

    //Runtime: 1 ms, faster than 83.53% of Java online submissions for Keyboard Row.
    //Memory Usage: 42.2 MB, less than 41.85% of Java online submissions for Keyboard Row.
    static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean inDiffRow = false;
            int row = inWhichRow(words[i].charAt(0));
            for (int j = 1; j < words[i].length(); j++) {
                if (row != inWhichRow(words[i].charAt(j))) {
                    inDiffRow = true;
                    break;
                }
            }
            if (!inDiffRow) {
                list.add(words[i]);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static int inWhichRow(char c) {
        if (first.contains((c + "").toLowerCase())) {
            return 1;
        } else if (second.contains((c + "").toLowerCase())) {
            return 2;
        } else return 3;
    }
}
