package LeetCode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1859 {
    //https://leetcode.com/problems/sorting-the-sentence/
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        //result: This is a sentence
    }

    public static String sortSentence(String s) {
        String[] wordsWithNumbers = s.split(" ");
        Arrays.sort(wordsWithNumbers, Comparator.comparingInt(t -> Integer.parseInt(t.charAt(t.length() - 1) + "")));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordsWithNumbers.length - 1; i++) {
            sb.append(wordsWithNumbers[i].substring(0, wordsWithNumbers[i].length() - 1) + " ");
        }
        return sb
                .append(wordsWithNumbers[wordsWithNumbers.length - 1].substring(0, wordsWithNumbers[wordsWithNumbers.length - 1].length() - 1))
                .toString();
    }
}
