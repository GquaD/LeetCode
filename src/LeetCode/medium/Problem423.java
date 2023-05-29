package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem423 {
    //https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoerv"));
    }

    //https://leetcode.com/problems/reconstruct-original-digits-from-english/solutions/3575911/java-using-alphabet-array/
    //15 min
    //Runtime
    //16 ms
    //Beats
    //15.52%
    //Memory
    //44.3 MB
    //Beats
    //5.17%
    static String[] digits;

    static String originalDigits(String s) {
        if (digits == null) genDigits();
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        List<Integer> list = new ArrayList<>();
        countNumbersFromAlphabet(alph, 'z', 0, list);
        countNumbersFromAlphabet(alph, 'w', 2, list);
        countNumbersFromAlphabet(alph, 'u', 4, list);
        countNumbersFromAlphabet(alph, 'x', 6, list);
        countNumbersFromAlphabet(alph, 'g', 8, list);
        countNumbersFromAlphabet(alph, 'o', 1, list);
        countNumbersFromAlphabet(alph, 't', 3, list);
        countNumbersFromAlphabet(alph, 'f', 5, list);
        countNumbersFromAlphabet(alph, 's', 7, list);
        countNumbersFromAlphabet(alph, 'i', 9, list);
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) sb.append(list.get(i));
        return sb.toString();
    }

    private static void genDigits() {
        digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    }

    private static void countNumbersFromAlphabet(int[] alph, char c, int n, List<Integer> list) {
        int t = alph[c - 'a'];
        if (t > 0) {
            for (int i = 0; i < t; i++) list.add(n);
            for (int i = 0; i < digits[n].length(); i++) alph[digits[n].charAt(i) - 'a'] -= t;
        }
    }

    //5-10 min
    //Runtime
    //35 ms
    //Beats
    //5.60%
    //Memory
    //44.9 MB
    //Beats
    //5.17%
    static String originalDigits1(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        //first round check unique letters 0, 2, 4, 6, 8
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (alph['z' - 'a'] > 0) {
            int t = alph['z' - 'a'];
            for (int i = 0; i < t; i++) pq.add(0);
            for (int i = 0; i < digits[0].length(); i++) alph[digits[0].charAt(i) - 'a'] -= t;
        }
        if (alph['w' - 'a'] > 0) {
            int t = alph['w' - 'a'];
            for (int i = 0; i < t; i++) pq.add(2);
            for (int i = 0; i < digits[2].length(); i++) alph[digits[2].charAt(i) - 'a'] -= t;
        }
        if (alph['u' - 'a'] > 0) {
            int t = alph['u' - 'a'];
            for (int i = 0; i < t; i++) pq.add(4);
            for (int i = 0; i < digits[4].length(); i++) alph[digits[4].charAt(i) - 'a'] -= t;
        }
        if (alph['x' - 'a'] > 0) {
            int t = alph['x' - 'a'];
            for (int i = 0; i < t; i++) pq.add(6);
            for (int i = 0; i < digits[6].length(); i++) alph[digits[6].charAt(i) - 'a'] -= t;
        }
        if (alph['g' - 'a'] > 0) {
            int t = alph['g' - 'a'];
            for (int i = 0; i < t; i++) pq.add(8);
            for (int i = 0; i < digits[8].length(); i++) alph[digits[8].charAt(i) - 'a'] -= t;
        }
        //second round
        if (alph['o' - 'a'] > 0) {
            int t = alph['o' - 'a'];
            for (int i = 0; i < t; i++) pq.add(1);
            for (int i = 0; i < digits[1].length(); i++) alph[digits[1].charAt(i) - 'a'] -= t;
        }
        if (alph['t' - 'a'] > 0) {
            int t = alph['t' - 'a'];
            for (int i = 0; i < t; i++) pq.add(3);
            for (int i = 0; i < digits[3].length(); i++) alph[digits[3].charAt(i) - 'a'] -= t;
        }
        if (alph['f' - 'a'] > 0) {
            int t = alph['f' - 'a'];
            for (int i = 0; i < t; i++) pq.add(5);
            for (int i = 0; i < digits[5].length(); i++) alph[digits[5].charAt(i) - 'a'] -= t;
        }
        if (alph['s' - 'a'] > 0) {
            int t = alph['s' - 'a'];
            for (int i = 0; i < t; i++) pq.add(7);
            for (int i = 0; i < digits[7].length(); i++) alph[digits[7].charAt(i) - 'a'] -= t;
        }
        if (alph['i' - 'a'] > 0) {
            int t = alph['i' - 'a'];
            for (int i = 0; i < t; i++) pq.add(9);
            for (int i = 0; i < digits[9].length(); i++) alph[digits[9].charAt(i) - 'a'] -= t;
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }
}
