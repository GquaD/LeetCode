package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem649 {
    //https://leetcode.com/problems/dota2-senate/
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRDRDRDRDDRDRDR"));
        System.out.println(predictPartyVictory("RDRDRDDRRRRDRDRDRDRR"));
        System.out.println(predictPartyVictory("DDRRR"));
    }

    private static String RADIANT = "Radiant", DIRE = "Dire";
    private static char R = 'R';

    //25 - 30min
    //https://leetcode.com/problems/dota2-senate/solutions/3483762/java-using-queue-and-stack-solution/
    //Runtime
    //30 ms
    //Beats
    //14.77%
    //Memory
    //43.5 MB
    //Beats
    //22.16%
    static String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) queue.offer(senate.charAt(i));
        Stack<Character> stack = new Stack<>();
        do {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char curr = queue.poll();
                if (stack.isEmpty()) {
                    stack.push(curr);
                } else {
                    char prev = stack.pop();
                    if (prev != curr) {
                        queue.offer(prev);
                    } else {
                        stack.push(prev);
                        stack.push(curr);
                    }
                }
            }
        } while (!queue.isEmpty());
        return stack.pop() == R ? RADIANT : DIRE;
    }
    //70/82
    static String predictPartyVictory1(String senate) {
        int countR = 0, countD = 0;
        for (int i = 0; i < senate.length(); i++) if (senate.charAt(i) == R) countR++;
        countD = senate.length() - countR;
        if (countR == countD) return senate.charAt(0) == R ? RADIANT : DIRE;
        else return countR > countD ? RADIANT : DIRE;
    }
}
