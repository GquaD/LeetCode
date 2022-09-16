package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1935 {
    //https://leetcode.com/problems/maximum-number-of-words-you-can-type/
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("leet code", "e"));
    }

    //Runtime: 4 ms, faster than 64.12% of Java online submissions for Maximum Number of Words You Can Type.
    //Memory Usage: 42.3 MB, less than 82.82% of Java online submissions for Maximum Number of Words You Can Type.
    static int canBeTypedWords(String text, String br) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean contains = false;
            for (int j = 0; j < br.length(); j++) {
                if (words[i].contains(br.charAt(j) + "")) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                list.add(words[i]);
            }
        }
        return list.size();
    }

    //Runtime: 10 ms, faster than 16.84% of Java online submissions for Maximum Number of Words You Can Type.
    //Memory Usage: 44.5 MB, less than 6.12% of Java online submissions for Maximum Number of Words You Can Type.
    static int canBeTypedWords3(String text, String br) {
        List<String> list = Arrays.asList(text.split(" "));
        for (int i = 0; i < br.length(); i++) {
            int finalI = i;
            list = list.stream().filter(s -> !s.contains(br.charAt(finalI) + "")).collect(Collectors.toList());
        }

        return list.size();
    }

    //Runtime: 29 ms, faster than 5.10% of Java online submissions for Maximum Number of Words You Can Type.
    //Memory Usage: 46.1 MB, less than 5.10% of Java online submissions for Maximum Number of Words You Can Type.
    static int canBeTypedWords2(String text, String br) {
        List<String> list = Arrays.asList(text.split(" "));
        for (int i = 0; i < br.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).contains(br.charAt(i) + "")) {
                    list.set(j, "");
                }
            }
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("")) {
                count++;
            }
        }
        return count;
    }

    static int canBeTypedWords1(String text, String br) {
        List<String> list = Arrays.asList(text.split(" "));
        for (int i = 0; i < br.length(); i++) {
            for (String word : list) {
                if (word.contains(br.charAt(i) + "")) {
                    list.remove(word);
                }
            }
        }
        return list.size();
    }
}
