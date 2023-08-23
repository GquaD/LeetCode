package LeetCode.easy;

import java.util.List;

public class Problem2828 {
    //https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/solutions/3950148/java-100-faster/
    //2min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //43.7 MB
    //Beats
    //69.18%
    static boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;
        for (int i = 0; i < words.size(); i++)
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        return true;
    }

    //1min
    //Runtime
    //2 ms
    //Beats
    //50.68%
    //Memory
    //43.7 MB
    //Beats
    //55.37%
    static boolean isAcronym1(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w.charAt(0));
        return s.equals(sb.toString());
    }
}
