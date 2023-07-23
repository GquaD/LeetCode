package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2788 {
    //https://leetcode.com/problems/split-strings-by-separator/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/split-strings-by-separator/solutions/3806366/java-100-faster-using-stringbuilder/
    //5-10min
    //Runtime
    //6 ms
    //Beats
    //100%
    //Memory
    //45.1 MB
    //Beats
    //40%
    static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String w = words.get(i);
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                if (c == separator) {
                    if (sb.length() > 0) list.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) list.add(sb.toString());
            sb.setLength(0);
        }
        return list;
    }
}
