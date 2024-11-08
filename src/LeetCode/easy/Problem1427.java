package LeetCode.easy;

import java.util.LinkedList;

public class Problem1427 {
    //https://leetcode.com/problems/perform-string-shifts/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/perform-string-shifts/solutions/6023016/java-using-double-ended-queue/
    //2min
    //Runtime
    //7
    //ms
    //Beats
    //6.85%
    //Analyze Complexity
    //Memory
    //41.92
    //MB
    //Beats
    //15.50%
    public String stringShift(String s, int[][] shift) {
        LinkedList<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        for (int[] arr: shift) {
            int dir = arr[0], amount = arr[1];
            if (dir == 0) {
                for (int i = 0; i < amount; i++) {
                    Character c = q.pollFirst();
                    q.addLast(c);
                }
            } else {
                for (int i = 0; i < amount; i++) {
                    Character c = q.pollLast();
                    q.addFirst(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: q) {
            sb.append(c);
        }
        return sb.toString();
    }
}
