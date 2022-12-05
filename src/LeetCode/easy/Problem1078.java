package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1078 {
    //https://leetcode.com/problems/occurrences-after-bigram/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOcurrences("we will we will rock you", "we", "will")));
    }

    //https://leetcode.com/problems/occurrences-after-bigram/solutions/2879550/java-1ms-solution/
    //Runtime
    //1 ms
    //Beats
    //85.11%
    //Memory
    //42 MB
    //Beats
    //55.34%
    static String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) list.add(split[i + 2]);
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    static String[] findOcurrences1(String text, String first, String second) {
        text = " " + text + " ";
        String piv = " " + first + " " + second + " ";
        List<String> list = new ArrayList<>();
        int idx = 0, searchIdx = text.indexOf(piv, idx);
        while (searchIdx > -1) {
            idx = searchIdx + piv.length();
            String s = text.substring(idx, text.indexOf(" ", idx));
            list.add(s);
            searchIdx = text.indexOf(piv, idx);
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
