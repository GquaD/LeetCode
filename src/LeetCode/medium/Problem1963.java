package LeetCode.medium;

public class Problem1963 {
    //https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //25 ms
    //Beats
    //49.55%
    //Memory
    //53.4 MB
    //Beats
    //42.75%
    static int minSwaps(String s) {
        int countOpen = 0, incorrect = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                countOpen++;
            } else {
                if (countOpen > 0) {
                    countOpen--;
                } else {
                    incorrect++;
                }
            }
        }
        return (incorrect + 1) / 2;
    }
}
