package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem422 {
    //https://leetcode.com/problems/valid-word-square
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-word-square/solutions/6097200/java-solution/
    //5min
    //Runtime
    //10
    //ms
    //Beats
    //81.94%
    //Analyze Complexity
    //Memory
    //42.31
    //MB
    //Beats
    //52.97%
    public boolean validWordSquare(List<String> words) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                String w = words.get(j);
                if (w.length() > i) sb.append(w.charAt(i));
            }
            list.add(sb.toString());
            sb.setLength(0);
        }
        if (words.size() != list.size()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).equals(list.get(i))) return false;
        }
        return true;
    }
}
