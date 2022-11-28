package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem345 {
    //https://leetcode.com/problems/reverse-vowels-of-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reverse-vowels-of-a-string/solutions/2855833/java-just-in-9-ms/
    //Runtime
    //10 ms
    //Beats
    //44.47%
    //Memory
    //45.5 MB
    //Beats
    //33.50%
    static String reverseVowels(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                list.add(c);
            }
        }
        Collections.reverse(list);
        int idx = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = list.get(idx++);
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
