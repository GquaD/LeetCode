package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem844 {
    //https://leetcode.com/problems/backspace-string-compare/
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ab#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    //Runtime: 5 ms, faster than 24.40% of Java online submissions for Backspace String Compare.
    //Memory Usage: 43.2 MB, less than 5.65% of Java online submissions for Backspace String Compare.
    static boolean backspaceCompare(String s, String t) {
        List<Character> listS = new LinkedList<>();
        List<Character> listT = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                listS.add(c);
            } else if (listS.size() > 0){
                listS.remove(listS.size() - 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                listT.add(c);
            } else if (listT.size() > 0){
                listT.remove(listT.size() - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> iteratorS = listS.iterator();
        while (iteratorS.hasNext()) {
            sb.append(iteratorS.next());
        }
        String s1 = sb.toString();
        sb.setLength(0);

        Iterator<Character> iteratorT = listT.iterator();
        while (iteratorT.hasNext()) {
            sb.append(iteratorT.next());
        }
        String t1 = sb.toString();
        return s1.equals(t1);
    }
}
