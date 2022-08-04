package LeetCode;

public class Problem2309 {
    //https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/

    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }

    //below
    //Runtime: 20 ms, faster than 17.70% of Java online submissions for Greatest English Letter in Upper and Lower Case.
    //Memory Usage: 43.6 MB, less than 11.58% of Java online submissions for Greatest English Letter in Upper and Lower Case.
    static String greatestLetter(String s) {
        String low = s.toLowerCase();
        int max = 0;
        for (int i = 0; i < low.length(); i++) {
            if (max < low.charAt(i) && (s.contains((char) (s.charAt(i) - 32) + ""))) {
                max = s.charAt(i);
            }
        }
        return max == 0 ? "" : (char) (max - 32) + "";
    }
}
