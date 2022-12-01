package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2451 {
    //https://leetcode.com/problems/odd-string-difference/
    public static void main(String[] args) {
        System.out.println(oddString(new String[]{"aaa","ccc","ddd","bob"}));
    }

    //https://leetcode.com/problems/odd-string-difference/solutions/2865375/java-2ms-solution/
    //Runtime
    //2 ms
    //Beats
    //79.25%
    //Memory
    //41.4 MB
    //Beats
    //75.83%
    static String oddString(String[] words) {
        int[][] arr = new int[words.length][words[0].length() - 1];
        //n - number of occurrences, n + 1 is last index of word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length() - 1; j++) {
                arr[i][j] = word.charAt(j + 1) - word.charAt(j);
            }
        }

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i - 1][j] != arr[i][j] && arr[i][j] != arr[i + 1][j]) {
                    return words[i];
                } else if (arr[i - 1][j] != arr[i][j]) {
                    return words[i - 1];
                } else if (arr[i + 1][j] != arr[i][j]) {
                    return words[i + 1];
                }
            }
        }
        return words[0];
    }
}
