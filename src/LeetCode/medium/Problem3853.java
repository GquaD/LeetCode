package LeetCode.medium;

import java.util.LinkedList;

public class Problem3853 {
    //10-15min

    //Runtime
    //14
    //ms
    //Beats
    //6.15%
    //Memory
    //45.28
    //MB
    //Beats
    //16.22%
    //https://leetcode.com/problems/merge-close-characters/solutions/7632612/java-linkedlist-solution-by-tbekpro-akfa/
    public String mergeCharacters(String s, int k) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
            list.add(s.charAt(i));

        int idx = -1;
        while ((idx = indexToDelete(list, k)) > 0) {
            list.remove(idx);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(c);

        return sb.toString();
    }

    private int indexToDelete(LinkedList<Character> list, int k) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= i + k && j < list.size(); j++) {
                if (list.get(i) == list.get(j)) return j;
            }
        }

        return -1;
    }

}
