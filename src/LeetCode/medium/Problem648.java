package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem648 {
    //https://leetcode.com/problems/replace-words/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
    }

    //https://leetcode.com/problems/replace-words/solutions/3580396/java-straightforward-solution/
    //10-15min
    //Runtime
    //211 ms
    //Beats
    //37.98%
    //Memory
    //53.7 MB
    //Beats
    //60.80%
    static String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, Comparator.comparing(String::length).thenComparing((o1, o2) -> o1.compareTo(o2)));
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            boolean added = false;
            for (String dict : dictionary) {
                if (word.startsWith(dict)) {
                    sb.append(dict).append(" ");
                    added = true;
                    break;
                }
            }
            if (!added) sb.append(word).append(" ");
        }
        return sb.replace(sb.length() - 1, sb.length(), "").toString();
    }
}
