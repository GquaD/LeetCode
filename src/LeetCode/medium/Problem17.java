package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem17 {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static void main(String[] args) {
        LeetCodeUtils.printList(letterCombinations("23"));
        LeetCodeUtils.printList(letterCombinations(""));
        LeetCodeUtils.printList(letterCombinations("3"));
    }

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/2709679/java-just-in-1-ms-2-solutions-using-random-and-recursion/
    //less than 1 hour for this solution
    //Runtime
    //1 ms
    //Beats
    //96.68%
    //Memory
    //42.6 MB
    //Beats
    //59.30%
    static char[][] buttons = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    static List<String> res;
    static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        res = new ArrayList<>();
        traverse(1, buttons[digits.charAt(0) - '0' - 2], digits, new StringBuilder());
        return res;
    }

    private static void traverse(int idx, char[] button, String digits, StringBuilder sb) {
        if (sb.length() >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < button.length; i++) {
            sb.append(button[i]);
            if (idx >= digits.length()) {
                traverse(idx + 1, button, digits, sb);
            } else {
                traverse(idx + 1, buttons[digits.charAt(idx) - '0' - 2], digits, sb);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    static class TrieNode {
        char character;
        List<Character> list;
    }

    //Runtime
    //6 ms
    //Beats
    //42.35%
    //Memory
    //42.9 MB
    //Beats
    //33.87%
    static char[][] letters = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    static List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        int numOfCombinations = 1;
        for (int i = 0; i < digits.length(); i++) {
            int len = letters[digits.charAt(i) - '0' - 2].length;
            numOfCombinations *= len;
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (set.size() < numOfCombinations) {
            for (int i = 0; i < digits.length(); i++) {
                char[] temp = letters[digits.charAt(i) - '0' - 2];
                int idx = random.nextInt(temp.length);
                sb.append(temp[idx]);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }
        return new ArrayList<>(set);
    }

    static List<String> result;
    static String dig;
/*    public List<String> letterCombinations1(String digits) {
        result = new ArrayList<>();
        dig = digits;
        for (int i = 0; i < digits.length(); i++) {
            char[] arr = letters[digits.charAt(i) - '0' - 2];
            for (int j = 0; j < arr.length; j++) {
                findCombinations(j, i, new ArrayList<>());
            }
//            findCombinations(i, new ArrayList<>());
        }
        return result;
    }*/

    /*private void findCombinations(int idxLetter, int idxButton, List<Character> list) {
        if (idxLetter >= letters[idxButton].length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            result.add(sb.toString());
            return;
        }
        list.add(letters[idxStart]);
        for (int i = idxStart + 1; i <= numbers.length; i++) {
            findCombinations(i, list);
        }
        list.remove(list.size() - 1);
    }*/
}
