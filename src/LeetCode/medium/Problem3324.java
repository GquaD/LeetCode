package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3324 {
    //https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/solutions/5942772/java-100-faster-solution/
    //5min
    //Runtime
    //14
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //56.10
    //MB
    //Beats
    //100.00%
    public List<String> stringSequence(String target) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i), temp = 'a';
            while (temp <= c) {
                list.add(sb.toString() + temp);
                temp = (char)(temp + 1);
            }
            sb.append(c);
        }
        return list;
    }
}
