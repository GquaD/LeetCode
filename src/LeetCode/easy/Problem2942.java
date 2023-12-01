package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2942 {
    //https://leetcode.com/problems/find-words-containing-character/
    public static void main(String[] args) {

    }

    //
    //2 min
    //Runtime
    //2 ms
    //Beats
    //68.98%
    //Memory
    //44.2 MB
    //Beats
    //44.84%
    static List<Integer> findWordsContaining(String[] words, char x) {
        String s = x + "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) if (words[i].contains(s)) list.add(i);;
        return list;
    }
}
