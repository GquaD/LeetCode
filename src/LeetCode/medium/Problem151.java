package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem151 {
    //https://leetcode.com/problems/reverse-words-in-a-string/

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }


    //20-30 mins
    //Runtime
    //18 ms
    //Beats
    //46.28%
    //Memory
    //43.7 MB
    //Beats
    //55.34%
    static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //didn't want to use split since I had to run thru twice
        //1 split
        //2 separating words from spaces
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) words.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) words.add(sb.toString());
        sb.setLength(0);
        Collections.reverse(words);
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i)).append(" ");
        }
        sb.append(words.get(words.size() - 1));
        return sb.toString();
    }
}
