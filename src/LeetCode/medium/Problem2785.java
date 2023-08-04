package LeetCode.medium;

import java.util.*;

public class Problem2785 {
    //https://leetcode.com/problems/sort-vowels-in-a-string/
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("LyMpH"));
    }

    //https://leetcode.com/problems/sort-vowels-in-a-string/solutions/3863262/java-priorityqueue-stringbuilder/
    //10 min
    //Runtime
    //85 ms
    //Beats
    //44.82%
    //Memory
    //47.5 MB
    //Beats
    //35.50%
    static char vowels[];

    static String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) if (isVowel(s.charAt(i))) pq.offer(s.charAt(i));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) sb.append(pq.poll());
            else sb.append(s.charAt(i));
            //sb.append(isVowel(s.charAt(i)) ? pq.poll() : s.charAt(i));
        }
        return sb.toString();
    }

    static boolean isVowel(char c) {
        if (vowels == null) vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char t : vowels) if (t == c) return true;
        return false;
    }

    static Set<Character> set;
    static boolean isVowel1(char c) {
        if (set == null) {
            set = new HashSet<>();
            set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        }
        return set.contains(c);
    }
}
