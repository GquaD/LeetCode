package LeetCode.easy;

public class Problem2114 {
    //https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
    public static void main(String[] args) {

    }
    //faster
    public static int mostWordsFound(String[] sentences) {
        int result = -1;
        for (String s : sentences) {
            int length = s.split(" ").length;
            if(length > result) {
                result = length;
            }
        }
        return result;
    }

    public static int mostWordsFound2(String[] sentences) {
        int result = -1;
        for (int i = 0; i < sentences.length; i++) {
            int length = sentences[i].split(" ").length;
            if(length > result) {
                result = length;
            }
        }
        return result;
    }
}
