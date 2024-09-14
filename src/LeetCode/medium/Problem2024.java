package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2024 {
    //https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximize-the-confusion-of-an-exam/solutions/5785634/java-o-n-sliding-window-solution/
    //15min
    //Runtime
    //20
    //ms
    //Beats
    //15.23%
    //Analyze Complexity
    //Memory
    //48.66
    //MB
    //Beats
    //6.00%
    static int maxConsecutiveAnswers(String answerKey, int k) {
        Queue<Integer> qf = new LinkedList<>(), qt = new LinkedList<>();
        int countF = 0, lastF = -1;
        int countT = 0, lastT = -1;
        int max = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            char cur = answerKey.charAt(i);
            if (cur == 'F') {
                qf.offer(i);
                if (countF == k) {
                    countF--;
                    max = Math.max(max, i - lastF - 1);
                    lastF = qf.poll();
                }
                countF++;
            } else {
                qt.offer(i);
                if (countT == k) {
                    countT--;
                    max = Math.max(max, i - lastT - 1);
                    lastT = qt.poll();
                }
                countT++;
            }
        }
        max = Math.max(max, Math.max(answerKey.length() - lastF - 1, answerKey.length() - lastT - 1));
        return max;
    }
}
